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

public class CUReservar_Habitacio extends ControladorCasUs {
	private Viatge viatge;
	private Date dataInici;
	private Date dataFinal;
	
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
	
	public void reservaHabitacio(String nomH) {
		CtrlHotel hc = DataControllerFactory.getInstance().getHotelController();
		
		Hotel h = hc.get(viatge.getNomCiutat(), nomH);
		Habitacio hab = h.getHabitacioLliure(dataInici, dataFinal);
		
		hab.afegeixViatge(viatge);
		HibernateUtil.update(hab);
	}
}
