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
	
	public HashSet<Pair<String,Float>> mostraHotelsLliures() throws Exception {
		cureservar_habitacio = new CUReservar_Habitacio();
    	return cureservar_habitacio.mostraHotelsLliures(dniClient, dataInici).getSecond();
	}
	
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
	
	public Boolean pagament(String numTarg, Date dataCad) throws Exception {
		IPagamentAdapter ipa = AdapterFactory.getInstance().getPagamentAdapter();
		
    	return ipa.pagament(dniClient, numTarg, (preuVol+preuHabitacio), dataCad);
	}
	
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
