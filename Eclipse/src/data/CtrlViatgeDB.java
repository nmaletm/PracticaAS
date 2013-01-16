package data;

import hibernate.HibernateUtil;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datainterface.CtrlViatge;
import domain.Viatge;

public class CtrlViatgeDB implements CtrlViatge {
	private static CtrlViatgeDB singleton;
	
	public static CtrlViatgeDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlViatgeDB() {};
	    return singleton;
	}
	
	public CtrlViatgeDB() {}

	
	@Override
	public Viatge get(String dni, Date dataIni) throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Viatge res = (Viatge) session.get(Viatge.class, Viatge.hashCode(dni, dataIni));
		session.close();
		if(res == null)
			throw new Exception("viatgeNoExisteix");
		return res;
	}

	@Override
	public Boolean exists(String dni, Date dataIni) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Viatge res = (Viatge) session.get(Viatge.class, Viatge.hashCode(dni, dataIni));
		session.close();

		return (res != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Viatge> all() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		List<Viatge> res = (List<Viatge>)session.createQuery("from "+Viatge.TAULA).list();
		session.close();
		return res;
	}
}
