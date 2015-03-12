package server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BallMover implements Runnable {

	Sprite ball;
	SessionFactory factory;
	int size;
	
	public BallMover(Sprite ball, SessionFactory factory, int size){
		this.ball = ball;
		this.factory = factory;
		this.size = size;
	}
	
	public void run() {
		while(true) {
			ball.move(size);
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			session.saveOrUpdate(ball);
			session.getTransaction().commit();
		}
	}

}
