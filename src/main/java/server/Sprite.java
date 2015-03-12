package server;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sprite implements Serializable{
	public final static Random random = new Random();
	
	final static int SIZE = 10;
	final static int MAX_SPEED = 5;
	final static int MAX_START_X = 100;
	final static int MAX_START_Y = 100;
	
	@Id
	@GeneratedValue
	private int id;
	
	private int x;
	private int y;
	private int dx;
	private int dy;
	private Color color; 

	public Sprite()
	{
		this.x = random.nextInt(MAX_START_X);
		this.y = random.nextInt(MAX_START_Y);
		this.dx = random.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.dy = random.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	
	public Sprite (int x, int y, Color c)
	{
		this.x = x;
		this.y = y;
		this.dx = random.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.dy = random.nextInt(2*MAX_SPEED) - MAX_SPEED;
		this.color = c;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, SIZE, SIZE);
	}
	
	public void move(int dimensions) {
		
		// check for bounce and make the ball bounce if necessary
        //
        if (x < 0 && dx < 0){
            //bounce off the left wall 
            x = 0;
            dx = -dx;
        }
        if (y < 0 && dy < 0){
            //bounce off the top wall
            y = 0;
            dy = -dy;
        }
        if (x > dimensions - SIZE && dx > 0){
            //bounce off the right wall
        	x = dimensions - SIZE;
        	dx = - dx;
        }       
        if (y > dimensions - SIZE && dy > 0){
            //bounce off the bottom wall
        	y = dimensions - SIZE;
        	dy = -dy;
        }

        //make the ball move
        x += dx;
        y += dy;
		
	}
}
