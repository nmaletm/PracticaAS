package datainterface;

public class DataControllerFactory {
	private static DataControllerFactory singleton;
    
	public static DataControllerFactory getInstance() {
        if (singleton == null) 
        	singleton = new DataControllerFactory() {};
        return singleton;
    }
	
	public DataControllerFactory() {}
}
