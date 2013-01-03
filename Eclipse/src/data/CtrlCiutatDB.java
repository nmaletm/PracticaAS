package data;

import java.util.List;

import datainterface.CtrlCiutats;
import domain.Ciutat;

public class CtrlCiutatDB implements CtrlCiutats {
	private static CtrlCiutatDB singleton;
	
	public static CtrlCiutatDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlCiutatDB() {};
	    return singleton;
	}
	
	public CtrlCiutatDB() {}

	@Override
	public Ciutat get(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean exists(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ciutat> all() {
		// TODO Auto-generated method stub
		return null;
	}
}
