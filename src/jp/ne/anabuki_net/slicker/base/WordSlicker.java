/**
 * 
 */
package jp.ne.anabuki_net.slicker.base;

import org.apache.log4j.Logger;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import jp.ne.anabuki_net.slicker.scene.*;
import jp.ne.anabuki_net.slicker.base.CustomProperties;

/** 起動部分
 * @author bluish_lvls */
public class WordSlicker extends StateBasedGame{
	/** Log */
	static Logger log=Logger.getLogger(WordSlicker.class);
	
	/** Save settings用Property file (全Version共通)*/ 
	public static CustomProperties propGlobal;
	/** Save settings用Property file */
	public static CustomProperties propConfig;
	/** 音楽リストProperty file */
	public static CustomProperties propMusic;
	

	public WordSlicker(){
		super("WordSlicker");
	}

	/* (non-Javadoc)
	 * @see
	 * org.newdawn.slick.state.StateBasedGame#initStatesList(org.newdawn.slick.
	 * GameContainer) */
	@Override public void initStatesList(GameContainer gc) throws SlickException{
		// TODO List up States
		this.addState(new StateLoadTitle());
		this.addState(new StateMainMenu());
		this.addState(new StatePlay());
	}

	/** @param args */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Log.setLogSystem(new LogSystemLog4j());
		log.info("WordSlick Start");
		
		try{
			AppGameContainer app=new AppGameContainer(new WordSlicker());
			app.setDisplayMode(800,600, false);
			app.setTargetFrameRate(60);
			//app.setClearEachFrame(false);
			app.setMinimumLogicUpdateInterval(0);
			app.setMaximumLogicUpdateInterval(0);
			app.setUpdateOnlyWhenVisible(false);
			app.setForceExit(false);
			app.start();
		}catch(SlickException e){
			log.fatal("Game initialize failed (SlickException)", e);
			e.printStackTrace();			// Exit
			System.exit(-1);
		}catch(Throwable e){
			log.fatal("Game initialize failed (NON-SlickException)", e);
			System.exit(-2);
		}

	}

}