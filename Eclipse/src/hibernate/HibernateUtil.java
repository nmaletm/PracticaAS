package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
  
    private static final SessionFactory sessionFactory = buildSessionFactory();
  
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            /* Axio es per fer-ho sense anotacions
             return new Configuration()
             
            
                    .configure()
                    .buildSessionFactory(); 
             */
            return new AnnotationConfiguration()
            	.configure()
            	.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    /*
    private static Object read(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        Object o = session.get(Hotel.class, id);
        session.close();
        return o;
    }
    */
    
    private static Object save(Object o) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        session.beginTransaction();
 
        session.save(o);
        
        session.getTransaction().commit();
         
        session.close();
 
        return o;
    }
 
    private static Object update(Object o) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        session.beginTransaction();
 
        session.merge(o);
         
        session.getTransaction().commit();
         
        session.close();
        return o;
 
    }
}
