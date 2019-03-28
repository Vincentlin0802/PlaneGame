package plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import util.Constant;





public class bullet extends GameObject{
	
	double degree;

	
	
	public bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.Game_Width/2;
		y = Constant.Game_Height/2;
		width = 10;
		height = 10;
	}
	public Rectangle getRect() {
		return new Rectangle((int)x,(int)y,10,10);
		
	}
	
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		if(y>Constant.Game_Height-height||y<30) {
			degree = -degree;
		}
		if(x<0||x>Constant.Game_Width-width) {
			degree = Math.PI-degree;
		}
		
		
		
		
		g.setColor(c);
		
	}	
	
}
