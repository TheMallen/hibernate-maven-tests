package persistence;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import server.Sprite;

public class HibernateUtils {
	 public static SessionFactory buildSessionFactory(){
 		Configuration config = new Configuration()
 								.addAnnotatedClass(Sprite.class)
 								.configure();
 		ServiceRegistry serviceRegistry;
 		serviceRegistry = new ServiceRegistryBuilder()
 								.applySettings(config.getProperties())
 								.buildServiceRegistry();
 		return config.buildSessionFactory(serviceRegistry);
	 }
}
