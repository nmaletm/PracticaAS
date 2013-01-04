package data;

import java.util.List;

import datainterface.CtrlHotel;
import domain.Hotel;

public class CtrlHotelDB implements CtrlHotel {
	private static CtrlHotelDB singleton;
	
	public static CtrlHotelDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlHotelDB() {};
	    return singleton;
	}
	
	public CtrlHotelDB() {}

	@Override
	public Hotel get(String nomCiutat, String nomHotel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean exists(String nomCiutat, String nomHotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> all() {
		// TODO Auto-generated method stub
		return null;
	}
}
