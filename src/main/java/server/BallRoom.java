package server;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import persistence.HibernateUtils;

public class BallRoom extends UnicastRemoteObject implements BallSession {

	private final int SIZE;
	private List<Sprite> ballz;
	private SessionFactory factory;
	private ExecutorService threadPool;
	
	protected BallRoom() throws RemoteException {
		this(400);
	}
	protected BallRoom(int size) throws RemoteException {
	    super();
		factory = HibernateUtils.buildSessionFactory();
		Session s = factory.getCurrentSession();
		threadPool = Executors.newCachedThreadPool();
		
		s.beginTransaction();
		this.ballz = s.createQuery("From Sprite").list();
		s.getTransaction().commit();
		
		SIZE = size;
		
		for (Sprite ball: ballz) {
			threadPool.execute(new BallMover(ball, factory, size));
		}
		
	
	}

	public void newSprite(int x, int y, Color c) throws RemoteException {
		Sprite ball = new Sprite(x,y,c);
		saveSprite(ball);
		ballz.add(ball);
		threadPool.execute(new BallMover(ball, factory, getSize()));
	}

	private void saveSprite(Sprite sprite) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(sprite);
		session.getTransaction().commit();
	}
	
	public List<Sprite> getList() throws RemoteException {
		return ballz;
	}

	public int getSize() throws RemoteException {
		return SIZE;
	}

}
