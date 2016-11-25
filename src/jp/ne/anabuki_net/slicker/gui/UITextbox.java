package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;
/** Use org.newdawn.slick.gui.TextField */
@Deprecated
public class UITextbox extends TextField{
	String value="";
	boolean password;
	public UITextbox(GameContainer c,Font f, int x,int y,int w, int h, boolean p){
		super(c,f,x,y,w,h);
		this.password=p;
	}
	public String getval(){
		return value;
	}
	@Override public void render(GUIContext c, Graphics g){
		// TODO Auto-generated method stub
		//if(load)
		super.render(c,g);
		g.drawString(value, x,y);
	}
}
