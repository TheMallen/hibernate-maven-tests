package hibernatestuffs;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import persistence.*;
import server.Sprite;

import java.awt.Color;
import java.util.List;

/**
 * Hello hibernate!
 */

public class App 
{
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtils.buildSessionFactory().openSession();
        session.beginTransaction();
        Sprite sprite = new Sprite(2, 1, Color.RED);
        session.save(sprite);
        session.save(new Sprite(2, 1, Color.BLUE));
        session.getTransaction().commit();
        
        Query q = session.createQuery("From Sprite");
        List<Sprite> list = q.list();
        System.out.println("Number of sprites:" + list.size());
    }
}
