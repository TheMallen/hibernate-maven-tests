package hibernatestuffs;

import hibernatestuffs.domain.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
        Session session = buildSessionFactory().openSession();
        session.beginTransaction();
        PersistentSprite sprite = new PersistentSprite(Color.RED, 1, 2);
        session.save(sprite);
        session.save(new PersistentSprite(Color.BLUE, 1, 2));
        session.getTransaction().commit();
        
        Query q = session.createQuery("From PersistentSprite");
        List<PersistentSprite> list = q.list();
        System.out.println("Number of sprites:" + list.size());
    }
    
    private static SessionFactory buildSessionFactory(){
    		Configuration config = new Configuration()
    									.configure();
    		serviceRegistry = new ServiceRegistryBuilder()
    								.applySettings(config.getProperties())
    								.buildServiceRegistry();
    		return config.buildSessionFactory(serviceRegistry);
   }
}
