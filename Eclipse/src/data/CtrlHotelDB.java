package data;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datainterface.CtrlHotel;
import domain.Hotel;

public class CtrlHotelDB implements CtrlHotel {
	private static CtrlHotelDB singleton;
	
	public static CtrlHotelDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlHotelDB() {};
	    return singleton;
	}
	
	public CtrlHotelDB() {}

	@Override
	public Hotel get(String nomCiutat, String nomHotel) throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Hotel res = (Hotel) session.get(Hotel.class, Hotel.hashCode(nomCiutat, nomHotel));
		session.close();
		
		return res;
	}

	@Override
	public Boolean exists(String nomCiutat, String nomHotel) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Hotel res = (Hotel) session.get(Hotel.class, Hotel.hashCode(nomCiutat, nomHotel));
		session.close();

		return (res != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> all() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		List<Hotel> res = (List<Hotel>)session.createQuery("from "+Hotel.TAULA).list();
		session.close();
		return res;
	}
}
