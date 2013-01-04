package adapters;

import java.util.Date;

public interface IPagamentAdapter {

	Boolean pagament(String dniClient, String numTarg, float f, Date dataCad) throws Exception;

}
