package data;

import datainterface.CtrlViatge;

public class CtrlViatgeDB implements CtrlViatge {
	private static CtrlViatgeDB singleton;
	
	public static CtrlViatgeDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlViatgeDB() {};
	    return singleton;
	}
	
	public CtrlViatgeDB() {}
}
