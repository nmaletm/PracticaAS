package data;

import datainterface.CtrlCiutats;

public class CtrlCiutatDB implements CtrlCiutats {
	private static CtrlCiutatDB singleton;
	
	public static CtrlCiutatDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlCiutatDB() {};
	    return singleton;
	}
	
	public CtrlCiutatDB() {}
}
