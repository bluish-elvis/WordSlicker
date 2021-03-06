package jp.ne.anabuki_net.slicker.scene;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import jp.ne.anabuki_net.slicker.gui.*;

public class StateMainMenu extends BaseGameState{
	/** This state's ID */
	public static final int ID=1;

	/** This state's Buttons */
	UISimpleButton Sw_Play, Sw_Config;
	UIScrollBar Scr;
	/** Log */
	static Logger log=Logger.getLogger(StateMainMenu.class);
	List<UIParts> components=new ArrayList<UIParts>();

	//TODO buttons & Login TextField
	public StateMainMenu(){

	}

	@Override public void init(GameContainer c, StateBasedGame game) throws SlickException{
		// UI Parts Assemble
		Sw_Play=new UISimpleButton(c, 100, 100, 128, 50, "Play",new ComponentListener(){
			
			@Override public void componentActivated(AbstractComponent source){
				game.enterState(StatePlay.ID);
			}
		});
		components.add(Sw_Play);
		Sw_Config=new UISimpleButton(c, 100,64, 128, 50, "Config",new ComponentListener(){
			
			@Override public void componentActivated(AbstractComponent source){
				//game.enterState(StateSetting.ID);
				
			}
		});
		components.add(Sw_Config);
		Scr=new UIScrollBar(c, 420, 10, 100, 100);
		components.add(Scr);
	}

	@Override public void renderImpl(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException{
		//background.draw(0 - camera.getX(), 0 - camera.getY(), 2100, 2100);

		for(UIParts b:components)
			b.render(gc, g);

		// TODO: parts all render
	}

	@Override public void updateImpl(GameContainer gc, StateBasedGame game, int delta) throws SlickException{
		// TODO Auto-generated method stub
	}

	@Override public int getID(){
		// TODO Auto-generated method stub
		return StateMainMenu.ID;
	}

}