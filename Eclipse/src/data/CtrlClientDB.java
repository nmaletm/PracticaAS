package data;

import java.util.List;

import datainterface.CtrlClient;
import domain.Client;

public class CtrlClientDB implements CtrlClient {
	private static CtrlClientDB singleton;
	
	public static CtrlClientDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlClientDB() {};
	    return singleton;
	}
	
	public CtrlClientDB() {}

	@Override
	public Client get(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean exists(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> all() {
		// TODO Auto-generated method stub
		return null;
	}
}
