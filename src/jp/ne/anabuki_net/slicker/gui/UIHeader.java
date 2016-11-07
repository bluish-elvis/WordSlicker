package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class UIHeader{
	String value="";
	int x,y,width,height;
	boolean password;
	UIHeader(int x,int y,int w, int h, boolean p){
		this.x=x;this.y=y;this.width=w;this.height=h;
		this.password=p;
	}
	public String getval(){
		return value;
	}
	public void render(GameContainer cont, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		g.drawRect(x, y, width,height);
		g.drawString(value, x,y);
	}
}
