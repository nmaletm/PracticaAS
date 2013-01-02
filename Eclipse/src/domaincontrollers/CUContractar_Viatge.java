package domaincontrollers;

import java.util.Date;
import java.util.HashSet;

import utility.Pair;

public class CUContractar_Viatge extends ControladorCasUs {
	private Float preuVol;
	private String dniClient;
	private String nomCiutat;
	private Date dataInici;
	private Date dataFinal;
	private Float preuHabitacio;
	private CUReservar_Habitacio cureservar_habitacio;
	
	public HashSet<Pair<String,Float>> obteCiutats() {
		return (new CUConsultar_Ciutats()).obteCiutats();
	}
	
	public void enregistraViatge(String dni, Date dataIni, Date dataFi, String nom) {
		/* TODO */
	}
	
	public HashSet<Pair<String,Float>> mostraHotelsLliures(String dniClient, Date dataInici) {
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
