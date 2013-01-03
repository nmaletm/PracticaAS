package domaincontrollers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import datainterface.CtrlCiutats;
import datainterface.DataControllerFactory;
import domain.Ciutat;

import utility.Pair;

public class CUConsultar_Ciutats extends ControladorCasUs {
	public HashSet<Pair<String,Float>> obteCiutats() throws Exception {
		CtrlCiutats cc = DataControllerFactory.getInstance().getCiutatsController();
		LinkedList<Ciutat> sc = (LinkedList<Ciutat>) cc.all();
		
		if (sc.size() == 0) throw new Exception("noHiHaCiutats");
		
		HashSet<Pair<String,Float>> resultat = new HashSet<Pair<String,Float>>();
		Iterator<Ciutat> it = sc.iterator();
		while (it.hasNext()) {
			Ciutat aux = (Ciutat) it.next();
			resultat.add(new Pair<String,Float>(aux.getNom(),aux.getPreuVol()));
		}
		
    	return resultat;
	}
}
