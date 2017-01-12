package jp.ne.anabuki_net.slicker.gui;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class UIScrollBar extends UIParts{
	UISimpleButton bUP,bDOWN;
	private int val=0,max=1;
	public UIScrollBar(GameContainer c, int x, int y, int h,int max){
		super(c, x, y, 1, h,null);
		bUP=new UISimpleButton(c,x-10,y-20,20,20,"",new ComponentListener(){
			@Override public void componentActivated(AbstractComponent source){
				val-=max/20;
			}});
		bDOWN=new UISimpleButton(c,x-10,y+h,20,20,"",new ComponentListener(){
			@Override public void componentActivated(AbstractComponent source){
				val+=max/20;
			}});
		setVisible(true);
		if(max<1)this.max=1;else this.max=max;
	}
	public void setvalue(int v){
		if(v<1)val=0;
		else if(v>max)val=max;
		else val=v;
	}
	public void addvalue(int v){
		val+=v;
		if(val<1)val=0;
		else if(val>max)val=max;
	} 
	@Override public void renderImpl(GUIContext c, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		if (bUP.isHold())val-=max/256;
		if (bDOWN.isHold())val+=max/256;
		if(val<1)val=0;
		else if(val>max)val=max;
		
			g.setColor(m_hold?Color.lightGray:(m_over?Color.darkGray:Color.black));
		
		g.fillOval(x-5, val/max+y-5, 10,10);
		g.setColor(Color.white);
		g.drawOval(x-10, y-10, 20,20);
		g.drawLine(x, y, x, y+height);

		bUP.render(c, g);
		bDOWN.render(c, g);
	}
}
