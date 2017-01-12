package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class UISimpleButton extends UIParts{
	String text;

	public UISimpleButton(GameContainer c, int x, int y, int w, int h, String t, ComponentListener l){
		super(c, x, y, w, h, l);
		text=t;
		setVisible(true);
	}

	@Override public void renderImpl(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		
		if(m_over||m_hold){
			g.setColor(m_hold?Color.lightGray:Color.darkGray);
			g.fillRect(x, y, width, height);
		}
		g.setColor(Color.white);
		g.drawRect(x, y, width, height);
		g.drawString(text, x, y+height/2);
	}
}
