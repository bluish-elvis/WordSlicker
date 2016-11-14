package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

public class UIHeader extends UIParts{
	
	String title="",text="";
	
	UIHeader(GameContainer c, String title){
		super(c, 0, 0, c.getScreenWidth(), c.getScreenHeight()/10);
		setTitle(title);
	}
	public void setTitle(String v){
		title=v;
	}
	@Override public void render(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		g.drawRect(0, 0, width, height);
		g.drawString(title, x, y);
	}
}
