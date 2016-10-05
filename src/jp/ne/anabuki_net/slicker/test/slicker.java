package jp.ne.anabuki_net.slicker.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

/** @author bluish */
public class slicker extends BasicGame{
	public slicker(){
		super("Wizard game");
	}

	public static void main(String[] arguments){
		try{
			AppGameContainer app=new AppGameContainer(new slicker());
			app.setDisplayMode(800, 600, false);
			app.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}

	@Override public void init(GameContainer container) throws SlickException{}

	@Override public void update(GameContainer container, int delta) throws SlickException{}

	public void render(GameContainer container, Graphics g) throws SlickException{}
}