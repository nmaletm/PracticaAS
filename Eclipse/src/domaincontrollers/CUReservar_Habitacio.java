package domaincontrollers;

import java.util.Date;
import java.util.HashSet;

import utility.Pair;

import datainterface.CtrlViatge;
import datainterface.DataControllerFactory;
import domain.Viatge;

public class CUReservar_Habitacio extends ControladorCasUs {
	private Viatge viatge;
	private Date dataIni;
	private Date dataFi;
	
	public Pair<Pair<String,Date>,HashSet<Pair<String,Float>>> mostraHotelsLliures(String dniClient, Date dataInici) throws Exception {
		CtrlViatge vc = DataControllerFactory.getInstance().getViatgeController();
		
		Viatge v = vc.get(dniClient, dataInici);
		
		HashSet<Pair<String, Float>> resultat = v.getHotelsLliures();
		
		if(resultat.size() == 0) throw new Exception("hotelsNoLliures");
		
		String nom = v.getNomCiutat();
		Date data = v.getDataFi();
		viatge = v;
		dataIni = dataInici;
		dataFi = data;
    	return new Pair<Pair<String,Date>,HashSet<Pair<String,Float>>>(new Pair<String,Date>(nom,data),resultat);
	}
	
	public void reservaHabitacio(String nomH) {
		/* TODO */		
	}
}
