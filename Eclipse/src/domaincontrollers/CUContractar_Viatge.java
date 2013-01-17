package domaincontrollers;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.HashSet;

import adapters.AdapterFactory;
import adapters.IPagamentAdapter;

import datainterface.CtrlCiutats;
import datainterface.CtrlClient;
import datainterface.CtrlHotel;
import datainterface.DataControllerFactory;
import domain.Ciutat;
import domain.Client;
import domain.Hotel;
import domain.Viatge;

import utility.Pair;

/** Implementació de la classe CUContractar_Viatge del paquet Domain Controllers. **/
public class CUContractar_Viatge extends ControladorCasUs {
	/** Atributs de la Classe **/
	private Float preuVol;
	private String dniClient;
	private String nomCiutat;
	private Date dataInici;
	private Date dataFinal;
	private Float preuHabitacio;
	
	/** Relació 0..1->0..1 amb la classe CUReservar_Habitacio, navegable en sentit CUContractar_Viatge->CUReservar_Habitacio. **/
	private CUReservar_Habitacio cureservar_habitacio;
	
    /** Implementació de l'operació obteCiutats.
	 *  Retorna el Nom i el PreuVol de totes les Ciutats del sistema. **/
	public HashSet<Pair<String,Float>> obteCiutats() throws Exception {
		return (new CUConsultar_Ciutats()).obteCiutats();
	}
	
    /** Implementació de l'operació enregistraViatge.
	 *  Dona d'alta una instància de Viatge pel Client dni, les Dates i la Ciutat nom, en el sistema. **/
	public void enregistraViatge(String dni, Date dataIni, Date dataFi, String nom) throws Exception {
		CtrlCiutats cc = DataControllerFactory.getInstance().getCiutatsController();
		CtrlClient ccl = DataControllerFactory.getInstance().getClientController();
		
		Ciutat c = cc.get(nom);
		Client cl = ccl.get(dni);
		
		Boolean b = cl.teViatge(dataIni, dataFi);
		if (b) throw new Exception("jaTeViatge");
		
		new Viatge(cl,dataIni,dataFi,c);
		
		float preu = c.getPreuVol();
		preuVol = preu;
		dniClient = dni;
		nomCiutat = nom;
		dataInici = dataIni;
		dataFinal = dataFi;
	}
	
    /** Implementació de l'operació mostraHotelsLliures.
	 *  Retorna el nom i el preu dels Hotels disponibles pel Viatge identificat per (dniClient,dataInici). **/
	public HashSet<Pair<String,Float>> mostraHotelsLliures() throws Exception {
		cureservar_habitacio = new CUReservar_Habitacio();
    	return cureservar_habitacio.mostraHotelsLliures(dniClient, dataInici).getSecond();
	}
	
    /** Implementació de l'operació resevarHabitacio.
	 *  Es crea una instància de l’associació Reserva entre el Viatge i una Habitacio disponible qualsevol de l'Hotel 
	 *  en el període del Viatge. Retorna el preu total del Viatge. **/
	public Float resevarHabitacio(String nomH) {
		cureservar_habitacio.reservaHabitacio(nomH);
		cureservar_habitacio = null;
		
		CtrlHotel hc = DataControllerFactory.getInstance().getHotelController();
		
		Hotel h = null;
		try { h = hc.get(nomCiutat, nomH);} catch (Exception e) {/** Precondició **/}
		
		Float preu = h.calculaPreuHabitacio(dataInici, dataFinal);
		preuHabitacio = preu;
		float resultat = preuHabitacio + preuVol;
		
    	return resultat;
	}
	
    /** Implementació de l'operació pagament.
	 *  Es crida la operació autoritza(dni, numTarg, import, dataCad,dAvui):Boolean del servei Bank Service amb les dades 
	 *  de la targeta i el preu total del viatge. Retorna cert si s'ha pogut realitzar la operació, fals en cas contrari. **/
	public Boolean pagament(String numTarg, Date dataCad) throws Exception {
		IPagamentAdapter ipa = AdapterFactory.getInstance().getPagamentAdapter();
		
    	return ipa.pagament(dniClient, numTarg, (preuVol+preuHabitacio), dataCad);
	}
	
	/** Getters i Setters dels atributs **/
	public Float getPreuVol() {
		return preuVol;
	}

	public String getDni() {
		return dniClient;
	}

	public Date getDataIni() {
		return dataInici;
	}

	public Date getDataFin() {
		return dataFinal;
	}
}
