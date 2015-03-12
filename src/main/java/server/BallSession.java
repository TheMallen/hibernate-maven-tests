package server;

import java.awt.Color;
import java.rmi.Remote;
import java.util.List;

public interface BallSession extends Remote {
	public void newSprite(int x, int y, Color c) throws java.rmi.RemoteException;
	public List<Sprite> getList() throws java.rmi.RemoteException;
	public int getSize() throws java.rmi.RemoteException;
}
