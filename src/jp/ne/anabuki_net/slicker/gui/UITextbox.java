package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class UITextbox extends UIParts{
	String value="";
	boolean password;
	UITextbox(GameContainer c, int x,int y,int w, int h, boolean p){
		super(c,x,y,w,h);
		this.password=p;
	}
	public String getval(){
		return value;
	}
	@Override public void render(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		super.render(c,g);
		g.drawString(value, x,y);
	}
}
