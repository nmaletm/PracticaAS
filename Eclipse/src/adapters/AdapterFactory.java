package adapters;

public class AdapterFactory {

	private static AdapterFactory singleton;
	
	public static AdapterFactory getInstance() {
	    if (singleton == null) 
	    	singleton = new AdapterFactory() {};
	    return singleton;
	}
	
	public AdapterFactory() {}

	public IPagamentAdapter getPagamentAdapter() {
		return new PagamentAdapter();
	}

}
