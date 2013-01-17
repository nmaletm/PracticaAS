package servicelocator;

public class ServiceLocator {
	private static ServiceLocator singleton;
    
	/** Implementació del patró Singleton. **/
	public static ServiceLocator getInstance() {
        if (singleton == null) 
        	singleton = new ServiceLocator() {};
        return singleton;
    }
	
	public ServiceLocator() {}

	public BankService find(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
