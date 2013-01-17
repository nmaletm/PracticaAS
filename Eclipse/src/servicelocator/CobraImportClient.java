package servicelocator;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import servicelocator.BankServiceStub.CobraImport;
import servicelocator.BankServiceStub.CobraImportResponse;

public class CobraImportClient {
	/*public static void main(String[] args) {
		boolean resultat = false;
		try{
			String dni = "12345";
			String dataCad = "03/13";
			String numTargeta = "098765";
			float imprt = 80;
			BankServiceStub stub= new BankServiceStub();
			CobraImport cobra = new CobraImport();
			cobra.setDniCl(dni);
			cobra.setDataCad(dataCad);
			cobra.setImprt(imprt);
			cobra.setNumTarg(numTargeta);
			CobraImportResponse res = stub.cobraImport(cobra);
			resultat = res.get_return();
			if(resultat){
				System.out.println("Cert");
			}
			else{
				System.out.println("Fals");
			}
		} catch (AxisFault e){
			e.printStackTrace();
		} catch (RemoteException e){
			e.printStackTrace();
		}
	}*/

	public boolean autoritza(String dniClient, String numTarg, float preu, String dataCad){
		boolean resultat = false;
		try{
			BankServiceStub stub= new BankServiceStub();
			CobraImport cobra = new CobraImport();
			cobra.setDniCl(dniClient);
			cobra.setDataCad(dataCad);
			cobra.setImprt(preu);
			cobra.setNumTarg(numTarg);
			CobraImportResponse res = stub.cobraImport(cobra);
			resultat = res.get_return(); 
		} catch (AxisFault e){
			e.printStackTrace();
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return resultat;
	}
}

