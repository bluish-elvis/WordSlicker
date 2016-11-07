package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class UISimpleButton{
	int x,y,width,height;
	String text;
	UISimpleButton(int x,int y,int w, int h, String t){
		this.x=x;this.y=y;width=w;height=h;
		text=t;
	}
	UISimpleButton(int x,int y,int w, int h){
		this.x=x;this.y=y;width=w;height=h;
	}
	public void render(GameContainer cont,Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		g.drawRect(x, y, width,height);
		g.drawString(text, x,y);
	}
}
