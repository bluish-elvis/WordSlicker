package jp.ne.anabuki_net.slicker.test;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

/** @author bluish */
public class slicker extends BasicGame implements KeyListener{
	float x=304, y=184;
	static final float SPEED=0.1f;
	String str="";
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

	@Override public void update(GameContainer gc, int delta) throws SlickException{
		float move=SPEED*delta;
		Input input=gc.getInput();
		if(input.isKeyDown(input.KEY_LEFT)) x-=move;
		else if(input.isKeyDown(input.KEY_RIGHT)) x+=move;

		if(input.isKeyDown(input.KEY_UP)) y-=move;
		else if(input.isKeyDown(input.KEY_DOWN)) y+=move;

	}

	public void render(GameContainer container, Graphics g) throws SlickException{
		g.drawRect(x-16, y-16, 32, 32);
		g.drawString(str, x-4, y-9);
	}

    @Override
    public void keyPressed(int key, char c) {
    	str=Input.getKeyName(key);
    }
}