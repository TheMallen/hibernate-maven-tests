package server;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

public class BallRoom extends UnicastRemoteObject implements BallSession {

	private final int SIZE;
	private ArrayList<Ball> ballz;
	
	protected BallRoom() throws RemoteException {
		this(400);
	}
	protected BallRoom(int size) throws RemoteException {
	    super();
	    ballz = new ArrayList<Ball>();
	    SIZE = size;
	}

	public void move() {
		for(Ball ball:ballz){
			try {
				ball.move(getSize());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void start() {
		(new Thread(){
			public void run(){
			    while(true) {
			    	  try {
				            Thread.sleep(40);  // wake up roughly 25 frames per second
				        }
			    	  catch ( InterruptedException exception ) {
			    		  exception.printStackTrace();
				      }		    	  
			    	  move();
			      }
			}
		}).start();
	}
	
	public void newSprite(int x, int y, Color c) throws RemoteException {
		Ball ball = new Ball(x,y,c);
		ballz.add(ball);
	}

	public ArrayList<Ball> getList() throws RemoteException {
		return ballz;
	}

	public int getSize() throws RemoteException {
		return SIZE;
	}

}
