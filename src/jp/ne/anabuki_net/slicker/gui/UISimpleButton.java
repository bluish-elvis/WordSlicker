package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class UISimpleButton extends UIParts{

	String text;
	boolean moused;

	UISimpleButton(GameContainer c, int x, int y, int w, int h, String t,ComponentListener l){
		super(c, x, y, w, h);
		addListener(l);
		text=t;
	}
	public void update(GameContainer gc, int delta) throws SlickException{
		Input input=gc.getInput();
		int mx=input.getAbsoluteMouseX();
		int my=input.getAbsoluteMouseY();
		if(mx>=x&&mx<=(x+width)&&my>=y&&my<=(y+height)){
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) moused=true;
			if(moused&&!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				moused=false;
				// TODO do a listeners event
			}
		}
	}

	@Override public void render(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		g.drawRect(x, y, width, height);
		g.drawString(text, x, y);
	}
}
