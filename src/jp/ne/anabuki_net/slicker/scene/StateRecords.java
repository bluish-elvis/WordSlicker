package jp.ne.anabuki_net.slicker.scene;

import org.apache.log4j.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.Music;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StateRecords extends BaseGameState{
	/** This state's ID */
	public static final int ID=1;
	/** Log */
	static Logger log=Logger.getLogger(StateRecords.class);
	UnicodeFont ufont;
	Image background;
	Music titleMusic;

	public StateRecords(){

	}

	@Override public void init(GameContainer container, StateBasedGame game) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override public void renderImpl(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override public void updateImpl(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override public int getID(){
		// TODO Auto-generated method stub
		return StateRecords.ID;
	}

}
