package domaincontrollers;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;

import datainterface.CtrlCiutats;
import datainterface.CtrlClient;
import datainterface.DataControllerFactory;
import domain.Ciutat;
import domain.Client;
import domain.Viatge;

import utility.Pair;

public class CUContractar_Viatge extends ControladorCasUs {
	private Float preuVol;
	private String dniClient;
	private String nomCiutat;
	private Date dataInici;
	private Date dataFinal;
	private Float preuHabitacio;
	private CUReservar_Habitacio cureservar_habitacio;
	
	public HashSet<Pair<String,Float>> obteCiutats() throws Exception {
		return (new CUConsultar_Ciutats()).obteCiutats();
	}
	
	public void enregistraViatge(String dni, Date dataIni, Date dataFi, String nom) throws Exception {
		CtrlCiutats cc = DataControllerFactory.getInstance().getCiutatsController();
		CtrlClient ccl = DataControllerFactory.getInstance().getClientController();
		
		Ciutat c = cc.get(nom);
		Client cl = ccl.get(dni);
		
		Boolean b = cl.teViatge(dataIni, dataFi);
		if (b) throw new Exception("jaTeViatge");
		
		HibernateUtil.save(new Viatge(cl,dataIni,dataFi,c));
		
		float preu = c.getPreuVol();
		preuVol = preu;
		dniClient = dni;
		nomCiutat = nom;
		dataInici = dataIni;
		dataFinal = dataFi;
	}
	
	public HashSet<Pair<String,Float>> mostraHotelsLliures() {
		cureservar_habitacio = new CUReservar_Habitacio();
    	return cureservar_habitacio.mostraHotelsLliures(dniClient, dataInici).getSecond();
	}
	
	public Float resevarHabitacio(String nomH) {
		/* TODO */
    	return null;
	}
	
	public Boolean pagament(String numTarg, Date dataCad) {
		/* TODO */
    	return null;
	}
}
