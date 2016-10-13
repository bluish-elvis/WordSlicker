package jp.ne.anabuki_net.slicker.scene;

import org.apache.log4j.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import jp.ne.anabuki_net.slicker.base.ResourceLoader;

public class StateLoadTitle extends BasicGameState{
	/** This state's ID */
	public static final int ID=0;
	/** Log */
	static Logger log=Logger.getLogger(StateLoadTitle.class);

	@Override public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException{
		// TODO Auto-generated method stub
		// 画像などを読み込み
		try{
			ResourceLoader.load();
		}catch(Throwable e){
			log.error("Resource load failed", e);
		}
	}

	@Override public void render(GameContainer cont, StateBasedGame game, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		//if(load)
		g.drawString("click to start", 300, 300);
	}

	@Override public void update(GameContainer cont, StateBasedGame game, int delta) throws SlickException{
		// TODO Auto-generated method stub
		Input input=cont.getInput();
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
			game.enterState(StateMainMenu.ID);
	}

	@Override public int getID(){
		// TODO Auto-generated method stub
		return StateLoadTitle.ID;
	}

}
