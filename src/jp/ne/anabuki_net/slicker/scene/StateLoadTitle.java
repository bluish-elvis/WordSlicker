package jp.ne.anabuki_net.slicker.scene;

import org.apache.log4j.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.StateBasedGame;
import jp.ne.anabuki_net.slicker.base.ResourceLoader;
import jp.ne.anabuki_net.slicker.gui.*;

public class StateLoadTitle extends BaseGameState{
	/** This state's ID */
	public static final int ID=0;
	private int load=0;
	private UISimpleButton Sw_Start;
	/** Log */
	static Logger log=Logger.getLogger(StateLoadTitle.class);

	@Override public void init(GameContainer c, StateBasedGame g) throws SlickException{
		// TODO Auto-generated method stub
		// 画像などを読み込み
		try{
			ResourceLoader.load();
			load=1;
		}catch(Throwable e){
			log.error("Resource load failed", e);
		}
		
		Sw_Start=new UISimpleButton(c, 200, 200, 128, 64, "click to start", new ComponentListener(){

			@Override public void componentActivated(AbstractComponent source){
				g.enterState(StateMainMenu.ID);
			}
		});
	}

	@Override public void renderImpl(GameContainer cont, StateBasedGame game, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load>=1)
			Sw_Start.render(cont, g);
	}

	@Override public void updateImpl(GameContainer cont, StateBasedGame game, int delta) throws SlickException{
		// TODO Auto-generated method stub
		if(load==1)
			load=2;

	}

	@Override public int getID(){
		// TODO Auto-generated method stub
		return StateLoadTitle.ID;
	}

}
