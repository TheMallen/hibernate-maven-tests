package server;

import java.awt.Color;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import persistence.HibernateUtils;

public class BallServer {
	
	public static void main(String[] args) {
		try{
			
		      BallRoom  b = new BallRoom();
		      
		      // This server runs the registry on port 8080
		      LocateRegistry.createRegistry(8081);
		      System.out.println( "Registry created" );
		      
		      // A client will need to look up the remote object at this machine's
		      // address, using the service name "BallRoom"
		      Naming.rebind("rmi://localhost:8081/BallRoom", b);
		      
		      
		} catch (Exception e) {
			System.out.println("Danger Bart Simpson: " + e);
		}
	}
	
}
