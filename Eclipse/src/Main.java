
import hibernate.HibernateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import datainterface.CtrlCiutats;
import datainterface.CtrlClient;
import datainterface.CtrlHotel;
import datainterface.CtrlViatge;
import datainterface.DataControllerFactory;
import domain.Ciutat;
import domain.Client;
import domain.Hotel;
import domain.Viatge;


public class Main {

	public static void main(String args[]) {

		printAjuda();
		char opcio = readOption();

		while(opcio != 'e'){
			switch(opcio){
				case 'a':
					printAjuda();
					break;
				case 'd':
					esborraDades();
					break;
				case 'c':
					posaCiutats();
					break;
				case 'r':
					System.out.println("Això mostrarà la pantalla que hem de mostrar, però com que encara no la tinc"
							+ " poso això per posar-ho més endevant...");
					break;
				default:
					System.out.println("No has introduit una opció correcte!");
			}

			opcio = readOption();
		}


	}
	
	private static void posaCiutats(){
	 	Ciutat c = new Ciutat();
    	c.setNom("Barcelona");
    	c.setDescripcio("BCN una gran ciutat");
    	c.setPreuVol(24);
    	HibernateUtil.save(c);
    	
    	c = new Ciutat();
    	c.setNom("Madrid");
    	c.setDescripcio("MAD una altre gran ciutat");
    	c.setPreuVol(25);
    	HibernateUtil.save(c);
    	
    	c = new Ciutat();
    	c.setNom("Tarragona");
    	c.setDescripcio("També coneguda com a Tarraco");
    	c.setPreuVol(30);
    	HibernateUtil.save(c);
	}

	private static void esborraDades(){
		// Esborrem totes les ciutats
		{
			CtrlCiutats cc = DataControllerFactory.getInstance().getCiutatsController();
			List<Ciutat> sc = (List<Ciutat>) cc.all();
			if (sc.size() > 0){
				Iterator<Ciutat> it = sc.iterator();
				while (it.hasNext()) {
					Ciutat aux = (Ciutat) it.next();
					HibernateUtil.delete(aux);
				}
			}
		}
		// Esborrem tots els clients
		{
			CtrlClient cc = DataControllerFactory.getInstance().getClientController();
			List<Client> sc = (List<Client>) cc.all();
			if (sc.size() > 0){
				Iterator<Client> it = sc.iterator();
				while (it.hasNext()) {
					Client aux = (Client) it.next();
					HibernateUtil.delete(aux);
				}
			}
		}
		// Esborrem tots els Hotels
		{
			CtrlHotel cc = DataControllerFactory.getInstance().getHotelController();
			List<Hotel> sc = (List<Hotel>) cc.all();
			if (sc.size() > 0){
				Iterator<Hotel> it = sc.iterator();
				while (it.hasNext()) {
					Hotel aux = (Hotel) it.next();
					HibernateUtil.delete(aux);
				}
			}
		}
		// Esborrem totes les ciutats
		{
			CtrlViatge cc = DataControllerFactory.getInstance().getViatgeController();
			List<Viatge> sc = (List<Viatge>) cc.all();
			if (sc.size() > 0){
				Iterator<Viatge> it = sc.iterator();
				while (it.hasNext()) {
					Viatge aux = (Viatge) it.next();
					HibernateUtil.delete(aux);
				}
			}
		}
		// També es podria fer una consulta sql delete from ...
	}
	
	
	private static char readOption(){
		System.out.println("\n---------------------------------");
		System.out.print("Opcio: ");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(line.length() == 0){
			return readOption();
		}
		return line.toLowerCase().charAt(0);
	}
	private static void printAjuda(){
		System.out.println("Menu:");
		System.out.println("A -> Ajuda");
		System.out.println("C -> Posa les ciutats necessaries");
		System.out.println("D -> Esborrar totes les dades");
		System.out.println("R -> Inicia UI programa ");
		System.out.println("E -> Sortir");
	}

}
