package domaincontrollers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import utility.Pair;
import datainterface.CtrlCiutats;
import datainterface.DataControllerFactory;
import domain.Ciutat;

/** Implementació de la classe CUConsultar_Ciutats del paquet Domain Controllers. **/
public class CUConsultar_Ciutats extends ControladorCasUs {
	
    /** Implementació de l'operació obteCiutats.
	 *  Retorna el Nom i el PreuVol de totes les Ciutats del sistema. **/
	public HashSet<Pair<String,Float>> obteCiutats() throws Exception {
		CtrlCiutats cc = DataControllerFactory.getInstance().getCiutatsController();
		List<Ciutat> sc = (List<Ciutat>) cc.all();
		
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
