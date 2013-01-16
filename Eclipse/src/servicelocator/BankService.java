package servicelocator;

import java.util.Date;

import ClientPracticaAS.Java Resources.src.src.CobraImportClient;

/** Dummy class per que de moment no peti tot **/
public class BankService {
    
	public Boolean autoritza(String dniClient, String numTarg, float preu, Date dataCad) throws Exception {
		
		CobraImportClient.autoritza(dniClient, numTarg, preu, dataCad.toString());
		return null;
	}
}
