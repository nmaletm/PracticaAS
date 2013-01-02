
import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import domain.Hotel;
 
 
public class Main {
 
    public static void main(String args[]) {
         
         
        // Lectura
        System.out.println("******* Lectura *******");
        List hotels = list();
        System.out.println("Total Hotels: " + hotels.size());
         
         
        // Escritura
        {
        System.out.println("******* Escritura *******");
	        Hotel hotel = new Hotel("Rey Juan Carlos", 200, "Barcelona");
	        hotel = save(hotel);
	        hotel = read(hotel.getId());
	        System.out.printf("%d %s %s \n", hotel.getId(), hotel.getNom(), hotel.getPreu());
	    }
          
         
        // Update
        System.out.println("******* UPDATE *******");
        Hotel hotel = read(1); // llegim l'hotel amb id 1
        System.out.println("Name Before Update:" + hotel.getNom());
        hotel.setNom("Ma Cristina");
        update(hotel);  // guardem l'hotel modificat
         
        hotel = read(1); // tornem a llegir hotel amb id 1
        System.out.println("Name Aftere Update:" + hotel.getNom());
         
         
        // Esborrar
        System.out.println("******* Esborrar *******");
        delete(hotel);
        Hotel hotel3 = read(hotel.getId());
        System.out.println("Object:" + hotel3);
    }
     
     
 
    private static List list() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        List hotels = session.createQuery("from Hotel").list();
        session.close();
        return hotels;
    }
    private static Hotel read(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        Hotel hotel = (Hotel) session.get(Hotel.class, id);
        session.close();
        return hotel;
    }
    private static Hotel save(Hotel hotel) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        session.beginTransaction();
 
        session.save(hotel);
      //  Long id = (Long) session.save(hotel);
      //  hotel.setId(id);
         
        session.getTransaction().commit();
         
        session.close();
 
        return hotel;
    }
 
    private static Hotel update(Hotel hotel) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
 
        session.beginTransaction();
 
        session.merge(hotel);
         
        session.getTransaction().commit();
         
        session.close();
        return hotel;
 
    }
 
    private static void delete(Hotel hotel) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
         
        session.beginTransaction();
         
        session.delete(hotel);
         
        session.getTransaction().commit();
         
        session.close();
    }
     
}
