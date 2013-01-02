package servicelocator;

public class ServiceLocator {
	private static ServiceLocator singleton;
    
	public static ServiceLocator getInstance() {
        if (singleton == null) 
        	singleton = new ServiceLocator() {};
        return singleton;
    }
	
	public ServiceLocator() {}
}
