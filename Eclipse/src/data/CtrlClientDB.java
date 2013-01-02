package data;

import datainterface.CtrlClient;

public class CtrlClientDB implements CtrlClient {
	private static CtrlClientDB singleton;
	
	public static CtrlClientDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlClientDB() {};
	    return singleton;
	}
	
	public CtrlClientDB() {}
}
