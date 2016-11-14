package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;

abstract class UIParts extends AbstractComponent{
	/** coordinate */
	protected int x, y, width, height;

	/** Constructor */
	public UIParts(GameContainer c, int x, int y, int w, int h){
		super(c);
		setLocation(x, y);
		this.width=w;
		this.height=h;
	}

	@Override public void render(GUIContext c, Graphics g) throws SlickException{
		g.drawRect(x, y, width, height);
	}
	@Override public void setLocation(int x, int y){
		this.x=x;
		this.y=y;
	}
	@Override public int getX(){
		return x;
	}
	@Override public int getY(){
		return y;
	}
	@Override public int getWidth(){
		return width;
	}
	@Override public int getHeight(){
		return height;
	}

}
