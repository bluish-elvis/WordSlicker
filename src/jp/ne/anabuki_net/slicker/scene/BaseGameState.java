package jp.ne.anabuki_net.slicker.scene;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/** Base state */
public abstract class BaseGameState extends BasicGameState{
	/** Screen Shot flag (Declared in BaseGameState; Don't override it!) */
	protected boolean screenShotFlag=false;

	/* Fetch this state's ID */
	@Override public int getID(){
		return 0;
	}

	/* State initialization */
	public void init(GameContainer container, StateBasedGame game) throws SlickException{}

	/** Draw the screen. BaseGameState will do the common things (such as
	 * Framerate Cap or Screen Shot) here.
	 * Your code will be in renderImpl, unless if you want do something
	 * special. */
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		// Lost the focus
		if(!container.hasFocus()){ return; }

		// Do user's code
		renderImpl(container, game, g);

		/* Do common things
		 * WordSlicker.drawFPS(container); // FPS counter
		 * if(screenShotFlag){
		 * // Create a screenshot
		 * WordSlicker.saveScreenShot(container, g);
		 * screenShotFlag=false;
		 * } */
	}

	/** Update the game. BaseGameState will do the common things (such as
	 * Framerate Cap or Screen Shot) here.
	 * Your code will be in updateImpl, unless if you want do something
	 * special. */
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException{
		// Lost the focus
		/*if(!container.hasFocus()){
			GameKey.gamekey[0].clear();
			GameKey.gamekey[1].clear();
			return;
		}*/

		// Do user's code
		updateImpl(container, game, delta);

		/* Screenshot button
		 * if(GameKey.gamekey[0].isPushKey(GameKeyDummy.BUTTON_SCREENSHOT))
		 * screenShotFlag=true;
		 * // Exit button
		 * if(GameKey.gamekey[0].isPushKey(GameKeyDummy.BUTTON_QUIT))
		 * container.exit(); */
	}

	/** Draw the screen. Your code will be here, unless if you want do something
	 * special.
	 * @param container GameContainer
	 * @param game StateBasedGame
	 * @param g Graphics
	 * @throws SlickException Something failed */
	void renderImpl(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{}

	/** Update the game. Your code will be here, unless if you want do something
	 * special.
	 * @param container GameContainer
	 * @param game StateBasedGame
	 * @param delta Time passed since the last execution
	 * @throws SlickException Something failed */
	void updateImpl(GameContainer container, StateBasedGame game, int delta) throws SlickException{}

}