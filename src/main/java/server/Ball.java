package server;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.io.Serializable;

import persistence.PersistentSprite;

public class Ball extends PersistentSprite implements Serializable {
	public final static Random ranSpeed = new Random();
	
	final static int SIZE = 10;
	final static int MAX_SPEED = 5;

	private int dx;
	private int dy;

	public Ball (int x, int y, Color color)
	{
		super(color, x, y);
		this.dx = ranSpeed.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.dy = ranSpeed.nextInt(2*MAX_SPEED) - MAX_SPEED;
	}
	
	public void draw(Graphics g){
		g.setColor(getColor());
		g.fillOval(getX(), getY(), SIZE, SIZE);
	}
	
	public void move(int dimensions) {
		
		// check for bounce and make the ball bounce if necessary
        //
        if (getX() < 0 && dx < 0){
            //bounce off the left wall 
            setX(0);
            dx = -dx;
        }
        if (getY() < 0 && dy < 0){
            //bounce off the top wall
            setY(0);
            dy = -dy;
        }
        if (getX() > dimensions - SIZE && dx > 0){
            //bounce off the right wall
        	setX(dimensions - SIZE);
        	dx = - dx;
        }       
        if (getY() > dimensions - SIZE && dy > 0){
            //bounce off the bottom wall
        	setY(dimensions - SIZE);
        	dy = -dy;
        }

        //make the ball move
        setX(dx + getX());
        setY(dy + getY());
		
	}
}
