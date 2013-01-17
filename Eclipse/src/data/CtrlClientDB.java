package data;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datainterface.CtrlClient;
import domain.Client;

public class CtrlClientDB implements CtrlClient {
	
	/** Implementació del patró Singleton. **/
	private static CtrlClientDB singleton;
	public static CtrlClientDB getInstance() {
	    if (singleton == null) 
	    	singleton = new CtrlClientDB() {};
	    return singleton;
	}
	
	public CtrlClientDB() {}

	@Override
	public Client get(String nom) throws Exception {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Client res = (Client) session.get(Client.class, nom);
		session.close();
		if(res == null)
			throw new Exception("clientNoExisteix");
		return res;
	}

	@Override
	public Boolean exists(String nom) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		Client res = (Client) session.get(Client.class, nom);
		session.close();

		return (res != null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> all() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		 
		List<Client> res = (List<Client>)session.createQuery("from "+Client.TAULA).list();
		session.close();
		return res;
	}
}
