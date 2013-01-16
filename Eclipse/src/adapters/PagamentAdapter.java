package adapters;

import java.util.Date;


import servicelocator.BankService;
import servicelocator.ServiceLocator;

public class PagamentAdapter implements IPagamentAdapter{

	@Override
	public Boolean pagament(String dniClient, String numTarg, float preu, Date dataCad) throws Exception {
		BankService bs = ServiceLocator.getInstance().find("BankService");
		return bs.autoritza(dniClient,numTarg,preu,dataCad);
	}
}
