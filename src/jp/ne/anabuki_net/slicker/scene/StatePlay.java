package jp.ne.anabuki_net.slicker.scene;


import jp.ne.anabuki_net.slicker.saver.MySQLConnector;

import org.apache.log4j.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.Music;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StatePlay extends BaseGameState{
	/** This state's ID */
	public static final int ID=1;
	/** Log */
	static Logger log=Logger.getLogger(StatePlay.class);
	UnicodeFont ufont;
	Image background;
	Music titleMusic;

	public StatePlay(){

	}

	@Override public void init(GameContainer container, StateBasedGame game) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override public void renderImpl(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		// TODO Auto-generated method stub

	}

	@Override public void updateImpl(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		// TODO Auto-generated method stub
		int uid=0,cid=0,score=0,flawles=0,time=0; 
		MySQLConnector ScoreUpdate = new MySQLConnector();
		ScoreUpdate.sendscore(uid,cid,score,flawles,time);
	}

	@Override public int getID(){
		// TODO Auto-generated method stub
		return StatePlay.ID;
	}

}
