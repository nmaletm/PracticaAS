package data;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datainterface.CtrlHabitacio;
import domain.Habitacio;

public class CtrlHabitacioDB implements CtrlHabitacio {
	
	/** Implementació del patró Singleton. **/
	private static CtrlHabitacioDB singleton;
	public static CtrlHabitacioDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlHabitacioDB() {};
	    return singleton;
	}
	
	public CtrlHabitacioDB() {}
	
	@Override
	public Habitacio get(Integer hotelId, Integer numero) throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Habitacio res = (Habitacio) session.get(Habitacio.class, Habitacio.hashCode(hotelId, numero));
		session.close();
		if(res == null)
			throw new Exception("viatgeNoExisteix");
		return res;
	}

	@Override
	public Boolean exists(Integer hotelId, Integer numero) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Habitacio res = (Habitacio) session.get(Habitacio.class, Habitacio.hashCode(hotelId, numero));
		session.close();

		return (res != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Habitacio> all() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		List<Habitacio> res = (List<Habitacio>)session.createQuery("from "+Habitacio.TAULA).list();
		session.close();
		return res;
	}
}
