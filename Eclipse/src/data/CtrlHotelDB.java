package data;

import datainterface.CtrlHotel;

public class CtrlHotelDB implements CtrlHotel {
	private static CtrlHotelDB singleton;
	
	public static CtrlHotelDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlHotelDB() {};
	    return singleton;
	}
	
	public CtrlHotelDB() {}
}
