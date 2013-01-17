package adapters;

/** Classe resultant de la implementació del patró Factoria, per a l'accés als Adaptadors. **/
public class AdapterFactory {

	/** Implementació del patró Singleton. **/
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
