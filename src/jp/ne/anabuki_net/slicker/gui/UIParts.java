package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.ComponentListener;

public abstract class UIParts extends AbstractComponent{
	/** coordinate */
	protected int x, y, height, width;
	/** button pressing flag */
	protected boolean m_over, m_hold;

	protected boolean visible=false;

	public UIParts(GUIContext c, int x, int y, int w, int h){
		super(c);
		this.x=x;
		this.y=y;
		this.height=h;
		this.width=w;

	}
	public UIParts(GUIContext c, int x, int y, int w, int h, ComponentListener l){
		this(c, x, y, w, h);
		if(l!=null)
			addListener(l);
	}

	@Override public int getHeight(){
		return height;
	}

	@Override public int getWidth(){
		return width;
	}

	@Override public int getX(){
		return x;
	}

	@Override public int getY(){
		return y;
	}

	@Override public void setLocation(int X, int Y){
		this.x=X;
		this.y=Y;
	}
	@Override public void mouseClicked(int button, int x, int y, int clickCount){
		super.mouseClicked(button, x, y, clickCount);
		if(listeners.size()>0&&visible&&m_hold&&m_over&&button==Input.MOUSE_LEFT_BUTTON){
			notifyListeners();
			consumeEvent();
			m_hold=false;
		}

	}
	@Override public void mousePressed(int button, int x, int y){
		super.mousePressed(button, x, y);
		if(button!=Input.MOUSE_LEFT_BUTTON)return;
		m_hold=m_over;
	}
	@Override public void mouseReleased(int button, int x, int y){
		
		m_hold=false;
	}

	@Override public void mouseMoved(int oldx, int oldy, int newx, int newy){
		if(newx>this.x&&newx<(this.x+this.width)
			&&newy>this.y&&newy<(this.y+this.height))
			m_over=true;
		else m_over=false;

	}
	public boolean isHold(){
		return m_hold && m_over;
	}
	public boolean isVisible(){
		return visible;
	}

	public void setVisible(boolean visible){
		this.visible=visible;
	}

	@Override public void render(GUIContext gc, Graphics gr) throws SlickException{
		renderImpl(gc,gr);
	}
	public void renderImpl(GUIContext gc, Graphics gr) throws SlickException{
		gr.setColor(Color.white);
		gr.drawRect(x, y, width, height);
		gr.drawString("common", x+width/2-gr.getFont().getWidth("TEST!!!!"), y+height/2-10);
	}
}