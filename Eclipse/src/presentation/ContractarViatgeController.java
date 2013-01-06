package presentation;

import java.util.Date;
import java.util.HashSet;

import utility.Pair;

import data.CtrlCiutatDB;
import domaincontrollers.CUContractar_Viatge;

public class ContractarViatgeController {
	
	private CUContractar_Viatge controladorDomini;
	private ContractarViatgeFrame view;
	
	/*Singleton start*/
	private static ContractarViatgeController singleton;
	
	public static ContractarViatgeController getInstance() {
	    if (singleton == null) 
	    	singleton = new ContractarViatgeController() {};
	    return singleton;
	}
	
	public ContractarViatgeController() {
		controladorDomini = new CUContractar_Viatge();
		view = new ContractarViatgeFrame();
	}
	/*Singleton end*/
	
	
	public void prOkObteCiutats() {
		HashSet<Pair<String, Float>> cjCiutats = new HashSet<Pair<String, Float>>();
		try {
			controladorDomini.obteCiutats();
		} catch (Exception e) {
			//if ("noHiHaCiutats".equals(e.getMessage())) {
			System.out.println(e.getMessage());
				view.mostraMissatge("El sistema no te ciutats");
			//}
		}
		view.mostraCiutats(cjCiutats);
	}
	
	public void prOkAssignaViatge(String ciutat, String dniCl, Date dataIni, Date dataFi) {
		
	}
	
	public void prSiReservar() {
		
	}
	
	public void prNoReservar() {
		
	}
	
	public void prOkReserva(String nomHotel, Float preuHotel) {
		
	}
	
	public void prOkPagarViatge(String numTarg, Date dataCad) {
		
	}
	
	public void prOkMissatgeFi() {
		
	}
	
	public void prCancelaReserva() {
		
	}
	
	public void prCancela() {
		
	}

}
