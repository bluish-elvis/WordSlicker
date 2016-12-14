package jp.ne.anabuki_net.slicker.scene;


import jp.ne.anabuki_net.slicker.saver.MySQLConnector;
import net.java.games.input.Component;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;
import org.newdawn.slick.Image;

public class StatePlay extends BaseGameState{
	/** This state's ID */
	public static final int ID=1;
	/** Log */
	static Logger log=Logger.getLogger(StatePlay.class);
	UnicodeFont ufont;
	Image background;
	Music titleMusic;
	
	String str="";
	
	public StatePlay(){
		
	}

	@Override public void init(GameContainer container, StateBasedGame game) throws SlickException{
		// TODO Auto-generated method stub
		

	}

	@Override public void renderImpl(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		// TODO Auto-generated method stub
		
		float x=304, y=184;
		
		g.setColor(Color.white);
		g.drawRect(x-16, y-16, 32, 32);
		g.drawString(str, x-4, y-9);
		
	}

	@Override public void updateImpl(GameContainer gc, StateBasedGame game, int delta) throws SlickException{
		// TODO Auto-generated method stub
		int uid=0,cid=0,score=0,flawles=0,time=0; 
		
		
		/* MySQLConnector ScoreUpdate = new MySQLConnector();
		ScoreUpdate.sendscore(uid,cid,score,flawles,time); */
	}
	@Override public void keyPressed(int key, char c) {
		// TODO 自動生成されたメソッド・スタブ
		super.keyPressed(key, c);
		str=""+c;
	}
	@Override public int getID(){
		// TODO Auto-generated method stub
		return StatePlay.ID;
	}

}
