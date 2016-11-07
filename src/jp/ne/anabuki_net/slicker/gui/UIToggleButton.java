package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class UIToggleButton extends UISimpleButton{
	boolean value;
	UIToggleButton(int x,int y,int w,int h,String t){super(x,y,w,h,t);
	}
	void setval(boolean v){value=v;}
	boolean getval(){return value;}

	public void render(GameContainer cont, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		super.render(cont, g);
	}
}
