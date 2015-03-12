package hibernatestuffs.domain;
import java.awt.Color;

import javax.persistence.*;

@Entity
@Table
public class PersistentSprite {
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer x;
	
	private Integer y;
	
	private Integer colorR;
	private Integer colorG;
	private Integer colorB;
	
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
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getColorR() {
		return colorR;
	}

	public void setColorR(Integer colorR) {
		this.colorR = colorR;
	}
	
	public Integer getColorG() {
		return colorG;
	}

	public void setColorG(Integer colorG) {
		this.colorG = colorG;
	}
	
	public Integer getColorB() {
		return colorB;
	}

	public void setColorB(Integer colorB) {
		this.colorB = colorB;
	}
	
	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
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
