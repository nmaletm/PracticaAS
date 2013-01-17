package domaincontrollers;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.HashSet;

import utility.Pair;

import datainterface.CtrlHotel;
import datainterface.CtrlViatge;
import datainterface.DataControllerFactory;
import domain.Habitacio;
import domain.Hotel;
import domain.Viatge;

/** Implementació de la classe CUReservar_Habitacio del paquet Domain Controllers. **/
public class CUReservar_Habitacio extends ControladorCasUs {
	/** Atributs de la Classe **/
	private Date dataInici;
	private Date dataFinal;
	
	/** Relació 0..1->0..1 amb la classe Viatge, navegable en sentit CUReservar_Habitacio->Viatge. **/
	private Viatge viatge;
	
	/** Implementació de l'operació mostraHotelsLliures.
	 *  Retorna el nom i el preu dels Hotels disponibles pel Viatge identificat per (dniClient,dataIni). **/
	public Pair<Pair<String,Date>,HashSet<Pair<String,Float>>> mostraHotelsLliures(String dniClient, Date dataIni) throws Exception {
		CtrlViatge vc = DataControllerFactory.getInstance().getViatgeController();
		
		Viatge v = vc.get(dniClient, dataIni);
		
		HashSet<Pair<String, Float>> resultat = v.getHotelsLliures();
		
		if(resultat.size() == 0) throw new Exception("hotelsNoLliures");
		
		String nom = v.getNomCiutat();
		Date data = v.getDataFi();
		viatge = v;
		dataInici = dataIni;
		dataFinal = data;
    	return new Pair<Pair<String,Date>,HashSet<Pair<String,Float>>>(new Pair<String,Date>(nom,data),resultat);
	}
	
	/** Implementació de l'operació resevarHabitacio.
	 *  Es crea una instància de l’associació Reserva entre el Viatge i una Habitacio disponible qualsevol de l'Hotel nomH
	 *  en el període del Viatge. **/
	public void reservaHabitacio(String nomH) {
		CtrlHotel hc = DataControllerFactory.getInstance().getHotelController();
		
		Hotel h = null;
		try { h = hc.get(viatge.getNomCiutat(), nomH);} catch (Exception e) {/** Precondició **/}
		Habitacio hab = h.getHabitacioLliure(dataInici, dataFinal);
		
		hab.afegeixViatge(viatge);
		HibernateUtil.update(hab);
	}
}
