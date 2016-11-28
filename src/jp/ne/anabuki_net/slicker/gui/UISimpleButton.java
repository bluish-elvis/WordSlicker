package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class UISimpleButton extends UIParts{
	String text;

	public UISimpleButton(GameContainer c, int x, int y, int w, int h, String t, ComponentListener l){
		super(c, x, y, w, h, l);
		text=t;
		visible=true;
	}

	@Override public void mouseReleased(int button, int x, int y){
		if(listeners.size()>0&&visible&&x>this.x&&x<(this.x+this.width)
			&&y>this.y&&y<(this.y+this.height)){
			notifyListeners();
			consumeEvent();
		}

	}

	@Override public void mouseMoved(int oldx, int oldy, int newx, int newy){

		if(newx>this.x&&newx<(this.x+this.width)
			&&newy>this.y&&newy<(this.y+this.height))
			over=true;

		else
			over=false;
	}

	@Override public void render(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		g.drawRect(x, y, width, height);
		g.drawString(text, x, y);
	}
}
