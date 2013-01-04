package data;

import java.util.Date;
import java.util.List;

import datainterface.CtrlViatge;
import domain.Viatge;

public class CtrlViatgeDB implements CtrlViatge {
	private static CtrlViatgeDB singleton;
	
	public static CtrlViatgeDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlViatgeDB() {};
	    return singleton;
	}
	
	public CtrlViatgeDB() {}

	@Override
	public Viatge get(String dni, Date dataIni) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean exists(String dni, Date dataIni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Viatge> all() {
		// TODO Auto-generated method stub
		return null;
	}
}
