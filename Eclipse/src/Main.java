
import hibernate.HibernateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import presentation.ContractarViatgeController;
import datainterface.CtrlCiutats;
import datainterface.CtrlClient;
import datainterface.CtrlHabitacio;
import datainterface.CtrlHotel;
import datainterface.CtrlViatge;
import datainterface.DataControllerFactory;
import domain.Ciutat;
import domain.Client;
import domain.Habitacio;
import domain.Hotel;
import domain.Viatge;


public class Main {

	public static void main(String args[]) throws Exception {

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
				case '1':
					posaDadesJoc1();
					break;
				case '2':
					posaDadesJoc2();
					break;
				case 'r':
					ContractarViatgeController.getInstance().inicia();
					break;
				default:
					System.out.println("No has introduit una opcio correcte!");
			}

			opcio = readOption();
		}


	}

	private static void posaDadesJoc2() throws Exception{
		esborraDades();
		// Posem els clients
		{
		 	Client c1 = new Client("11111111","Marc","46513121",null);
		 	Client c2 = new Client("22222222","Andreu","54665421",null);
	    	Client c3 = new Client("33333333","Xavi","4654232",null);
	    	Client c4 = new Client("44444444","Nestor","56454512",null);
		}
		
		List<Hotel> llistaHotels1 = new ArrayList<Hotel>();		
		// Creem un hotel amb 3 habitacions
		{
			Integer hotelID = Hotel.hashCode("Barcelona (R)", "Rey Juan Carlos");
			List<Habitacio> llistaHab = new ArrayList<Habitacio>();
			{
				Habitacio hab = new Habitacio(hotelID,3);
				llistaHab.add(hab);
			}
			{
				Habitacio hab = new Habitacio(hotelID,5);
				llistaHab.add(hab);
			}
			{
				Habitacio hab = new Habitacio(hotelID,4);
				llistaHab.add(hab);
			}
	    	Hotel h = new Hotel("Barcelona (R)","Rey Juan Carlos", 300,llistaHab);
	    	llistaHotels1.add(h);
		}
		
		List<Hotel> llistaHotels2 = new ArrayList<Hotel>();		
		// Creem un hotel amb 3 habitacions
		{
			Integer hotelID = Hotel.hashCode("Madrid", "Rey Juan Carlos");
			List<Habitacio> llistaHab = new ArrayList<Habitacio>();
			{
				Habitacio hab = new Habitacio(hotelID,3);
				llistaHab.add(hab);
			}
			{
				Habitacio hab = new Habitacio(hotelID,5);
				llistaHab.add(hab);
			}
			{
				Habitacio hab = new Habitacio(hotelID,4);
				llistaHab.add(hab);
			}
	    	Hotel h = new Hotel("Madrid","Rey Juan Carlos", 300,llistaHab);
	    	llistaHotels2.add(h);
		}
		
		// Posem les ciutats
		{
		 	Ciutat c1 = new Ciutat("Barcelona (R)","BCN una gran ciutat",24,llistaHotels1);
		 	Ciutat c2 = new Ciutat("Madrid","MAD una altre gran ciutat",25,llistaHotels2);
		}
	}

	private static void posaDadesJoc1() throws Exception{
		esborraDades();
		// Posem els clients
		{
		 	Client c1 = new Client("11111111","Marc","46513121",null);
		 	Client c2 = new Client("22222222","Andreu","54665421",null);
	    	Client c3 = new Client("33333333","Xavi","4654232",null);
	    	Client c4 = new Client("44444444","Nestor","56454512",null);
		}
		
		List<Hotel> llistaHotels = new ArrayList<Hotel>();		
		// Creem un hotel amb 3 habitacions
		{
			Integer hotelID = Hotel.hashCode("Barcelona", "Rey Juan Carlos");
			List<Habitacio> llistaHab = new ArrayList<Habitacio>();
			{
				Habitacio hab = new Habitacio(hotelID,3);
				llistaHab.add(hab);
			}
			{
				Habitacio hab = new Habitacio(hotelID,5);
				llistaHab.add(hab);
			}
			{
				Habitacio hab = new Habitacio(hotelID,4);
				llistaHab.add(hab);
			}
	    	Hotel h = new Hotel("Barcelona","Rey Juan Carlos", 300,llistaHab);
	    	llistaHotels.add(h);
		}
		
		// Posem les ciutats
		{
		 	Ciutat c1 = new Ciutat("Barcelona","BCN una gran ciutat",24,llistaHotels);
		 	//Ciutat c2 = new Ciutat("Madrid","MAD una altre gran ciutat",25,null);
		 	//Ciutat c3 = new Ciutat("Tarragona","Tambe coneguda com a Tarraco",30,null);
		}
	}
	
	private static void esborraDades(){
		/*
		HibernateUtil.emptyTable(Viatge.TAULA);
		HibernateUtil.emptyTable(Habitacio.TAULA);
		HibernateUtil.emptyTable(Hotel.TAULA);
		HibernateUtil.emptyTable(Ciutat.TAULA);
		HibernateUtil.emptyTable(Client.TAULA);
		*/
		
		// Esborrem tots els viatges
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
		// Esborrem totes les Habitacions
		{
			CtrlHabitacio cc = DataControllerFactory.getInstance().getHabitacioController();
			List<Habitacio> sc = (List<Habitacio>) cc.all();
			if (sc.size() > 0){
				Iterator<Habitacio> it = sc.iterator();
				while (it.hasNext()) {
					Habitacio aux = (Habitacio) it.next();
					HibernateUtil.delete(aux);
				}
			}
		}
		
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
		System.out.println("1 -> Posa les dades del joc de proves 1");
		System.out.println("2 -> Posa les dades del joc de proves 2");
		System.out.println("D -> Esborrar totes les dades");
		System.out.println("R -> Inicia UI programa ");
		System.out.println("E -> Sortir");
	}

}
