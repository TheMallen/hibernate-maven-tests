package persistence;
import java.awt.Color;

import javax.persistence.*;

@Entity
@Table
public class PersistentSprite {
	@Id
	@GeneratedValue
	private Long id;
	
	private int x;
	
	private int y;
	
	private int colorR;
	private int colorG;
	private int colorB;
	
	public PersistentSprite() {}
	
	public PersistentSprite(Color color, int x, int y) {
		this.setColor(color);
		this.setX(x);
		this.setY(y);
	}

	public Long getId(){
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getColorR() {
		return colorR;
	}

	public void setColorR(int colorR) {
		this.colorR = colorR;
	}
	
	public int getColorG() {
		return colorG;
	}

	public void setColorG(int colorG) {
		this.colorG = colorG;
	}
	
	public int getColorB() {
		return colorB;
	}

	public void setColorB(int colorB) {
		this.colorB = colorB;
	}
	
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return new Color(this.colorR, this.colorG, this.colorB);
	}

	public void setColor(Color color) {
		this.colorR = color.getRed();
		this.colorG = color.getGreen();
		this.colorB = color.getBlue();
	}
	
	@Override
    public String toString() {
        return "Sprite [id=" + id + ", color=" +
        		colorR + "," + colorG + "," + colorB + "]";
    }
	
}
