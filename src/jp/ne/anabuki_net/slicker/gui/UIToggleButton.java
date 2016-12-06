package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class UIToggleButton extends UISimpleButton{
	private boolean value;

	public UIToggleButton(GameContainer c, int x, int y, int w, int h, String t){
		super(c, x, y, w, h,t,new ComponentListener(){
			@Override public void componentActivated(AbstractComponent source){
				
			}
			
		});
		
	}
	UIToggleButton(GameContainer c, int x, int y, int w, int h, String t, boolean v){
		this(c, x, y, w, h, t);
		setval(v);
	}
	void setval(boolean v){
		value=v;
	}
	boolean getval(){
		return value;
	}

	@Override public void render(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(value)
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
		g.drawString(text, x, y);
	}
}
