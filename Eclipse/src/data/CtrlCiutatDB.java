package data;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datainterface.CtrlCiutats;
import domain.Ciutat;

public class CtrlCiutatDB implements CtrlCiutats {
	private static CtrlCiutatDB singleton;
	
	public static CtrlCiutatDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlCiutatDB() {};
	    return singleton;
	}
	
	public CtrlCiutatDB() {}

	@Override
	public Ciutat get(String nom) throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Ciutat res = (Ciutat) session.get(Ciutat.class, nom);
		session.close();
		
		return res;
	}

	@Override
	public Boolean exists(String nom) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Ciutat res = (Ciutat) session.get(Ciutat.class, nom);
		session.close();

		return (res != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciutat> all() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		List<Ciutat> res = (List<Ciutat>)session.createQuery("from "+Ciutat.TAULA).list();
		session.close();
		return res;
	}
}
