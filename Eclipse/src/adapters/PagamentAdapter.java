package adapters;

import java.net.ConnectException;
import java.util.Date;

import servicelocator.CobraImportClient;
import servicelocator.ServiceLocator;

public class PagamentAdapter implements IPagamentAdapter{

	@Override
	public Boolean pagament(String dniClient, String numTarg, float preu, Date dataCad) throws Exception {
		CobraImportClient bs = (CobraImportClient)ServiceLocator.getInstance().find("BankService");
		return bs.autoritza(dniClient,numTarg,preu,dataCad.toString());
	}
}
