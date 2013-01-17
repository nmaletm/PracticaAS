package datainterface;

import data.CtrlCiutatDB;
import data.CtrlClientDB;
import data.CtrlHabitacioDB;
import data.CtrlHotelDB;
import data.CtrlViatgeDB;

public class DataControllerFactory {
	private static DataControllerFactory singleton;
	private static CtrlCiutats ctrlciutats;
	private static CtrlClient ctrlclient;
	private static CtrlHotel ctrlhotel;
	private static CtrlViatge ctrlviatge;
	private static CtrlHabitacio ctrlhabitacio;
	
	public static DataControllerFactory getInstance() {
        if (singleton == null) 
        	singleton = new DataControllerFactory() {};
        return singleton;
    }
	
	public DataControllerFactory() {}
	
	public CtrlCiutats getCiutatsController() {
		if (ctrlciutats == null)
			ctrlciutats = CtrlCiutatDB.getInstance();
		return ctrlciutats;
	}
	
	public CtrlClient getClientController() {
		if (ctrlclient == null)
			ctrlclient = CtrlClientDB.getInstance();
		return ctrlclient;
	}
	
	public CtrlHotel getHotelController() {
		if (ctrlhotel == null)
			ctrlhotel = CtrlHotelDB.getInstance();
		return ctrlhotel;
	}
	
	public CtrlViatge getViatgeController() {
		if (ctrlviatge == null)
			ctrlviatge = CtrlViatgeDB.getInstance();
		return ctrlviatge;
	}
	
	public CtrlHabitacio getHabitacioController() {
		if (ctrlhabitacio == null)
			ctrlhabitacio = CtrlHabitacioDB.getInstance();
		return ctrlhabitacio;
	}
}
