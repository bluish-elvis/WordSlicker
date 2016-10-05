package jp.ne.anabuki_net.slicker.base;

import java.awt.Color;
import java.io.File;
import java.util.LinkedList;
import org.apache.log4j.Logger;
import org.newdawn.slick.BigImage;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.font.effects.ShadowEffect;
import org.newdawn.slick.openal.SoundStore;
import jp.ne.anabuki_net.slicker.base.BGMStatus;
import jp.ne.anabuki_net.slicker.base.SoundManager;

/** 画像:
 * @author bluish_lvls */
public class ResourceLoader{
	/** Log */
	static Logger log=Logger.getLogger(ResourceLoader.class);
	/** 背景画像 */
	public static LinkedList<Image> imgBackList;
	/** 汎用画像フォント */
	public static Image imgFonts;
	/** TTF font */
	public static UnicodeFont ttfFont;
	/** Sound effects */
	public static SoundManager soundManager;
	/** BGM */
	public static Music[] bgm;
	/** Current BGM number */
	public static int bgmPlaying=-1;
	
	static int numBacks=0,numBGMs=0;
	@SuppressWarnings("unchecked") public static void load() throws SlickException{
		
		File file=null;
		while(true){
			file=new File("res/graphics/back"+numBacks+".png");
			if(file.canRead()) numBacks++;
			else break;
		}
		log.debug(numBacks+" backgrounds found");
		while(true){
			file=new File("res/sounds/bgm"+numBGMs+".ogg");
			if(file.canRead()) numBGMs++;
			else break;
		}
		log.debug(numBGMs+" BGMs found");

		imgBackList=new LinkedList<Image>();

		for(int i=0; i<numBacks; i++)
			imgBackList.add(loadImage("res/graphics/back"+i+".png"));

		// 音楽
		bgm=new Music[numBGMs];
		if(WordSlicker.propConfig.getProperty("option.bgmpreload", false)==true)
			for(int i=0; i<numBGMs; i++)
				bgmLoad(i, false);
		
		// Image Fonts
		imgFonts=loadImage("res/graphics/font.png");
		// Font
		try{
			ttfFont=new UnicodeFont("res/font/font.ttf", 16, false, false);
			ttfFont.getEffects().add(new ShadowEffect(Color.black, 1, 1, 1));
			ttfFont.getEffects().add(new ColorEffect(java.awt.Color.white));
		}catch(Throwable e){
			log.error("TTF Font load failed", e);
			ttfFont=null;
		}

		// Sound effects
		soundManager=new SoundManager();
		if(WordSlicker.propConfig.getProperty("option.se", true)==true){
			try{
				SoundStore.get().init();
			}catch(Throwable e){
				log.warn("Sound init failed", e);
			}

			log.info("Loading Sound Effect");
			soundManager.load("cursor", "res/se/cursor.wav");
			soundManager.load("decide0", "res/se/decide0.wav");
			soundManager.load("decide1", "res/se/decide1.wav");
			soundManager.load("decide2", "res/se/decide2.wav");

		}

	}
	/** 画像読み込み
	 * @param filename Filename
	 * @return 画像 data */
	public static Image loadImage(String filename){
		log.debug("Loading image from "+filename);

		Image img=null;
		try{
			img=new Image(filename);
		}catch(Throwable e){
			log.error("Failed to load image from "+filename, e);
			try{
				img=new Image(256, 256);
			}catch(Throwable e2){}
		}

		return img;
	}

	/** 巨大画像を読み込み
	 * @param filename Filename
	 * @return 画像 data */
	public static BigImage loadBigImage(String filename){
		log.debug("Loading big image from "+filename);

		BigImage bigImg=null;
		try{
			bigImg=new BigImage(filename);
		}catch(Throwable e){
			log.error("Failed to load big image from "+filename, e);
		}

		return bigImg;
	}

	/** 指定した numberのBGMをメモリ上に読み込み
	 * @param no BGM number
	 * @param showerr 例外が発生したときにコンソールに表示する */
	public static void bgmLoad(int no, boolean showerr){
		if(WordSlicker.propConfig.getProperty("option.bgm", false)==false) return;
		if(bgm[no]==null){
			if(showerr) log.info("Loading BGM"+no);

			try{
				String filename="res/sounds/bgm"+numBGMs+".ogg";
				if(filename==null||filename.length()<1){
					if(showerr) log.info("BGM"+no+" not available");
					return;
				}

				boolean streaming=WordSlicker.propConfig.getProperty("option.bgmstreaming", true);

				bgm[no]=new Music(filename, streaming);

				if(!showerr) log.info("Loaded BGM"+no);
			}catch(Throwable e){
				if(showerr) log.error("BGM "+no+" load failed", e);
				else log.warn("BGM "+no+" load failed");
			}
		}
	}

	/** 指定した numberのBGMを再生
	 * @param no BGM number */
	public static void bgmStart(int no){
		if(WordSlicker.propConfig.getProperty("option.bgm", false)==false) return;

		bgmStop();

		int bgmvolume=WordSlicker.propConfig.getProperty("option.bgmvolume", 128);
		//WordSlicker.app.setMusicVolume(bgmvolume/(float)128);

		if(no>=0){
			if(bgm[no]==null) bgmLoad(no, true);

			if(bgm[no]!=null) try{
				if(WordSlicker.propMusic.getProperty("music.noloop."+no, false)==true) bgm[no].play();
				else bgm[no].loop();
			}catch(Throwable e){
				log.error("Failed to play music "+no, e);
			}

			bgmPlaying=no;
		}else bgmPlaying=-1;
	}

	/** Current BGMを一時停止 */
	public static void bgmPause(){
		if(bgmPlaying>=0) if(bgm[bgmPlaying]!=null) bgm[bgmPlaying].pause();
	}

	/** 一時停止中のBGMを再開 */
	public static void bgmResume(){
		if(bgmPlaying>=0) if(bgm[bgmPlaying]!=null) bgm[bgmPlaying].resume();
	}

	/** BGM再生中かどうか
	 * @return 再生中ならtrue */
	public static boolean bgmIsPlaying(){
		if(bgmPlaying>=0) if(bgm[bgmPlaying]!=null) return bgm[bgmPlaying].playing();

		return false;
	}

	/** BGMを停止 */
	public static void bgmStop(){
		int i=bgmPlaying;
		if(i>=0)
			if(bgm[i]!=null){
			bgm[i].pause();
			bgm[i].stop();
			}
	}

	/** 全てのBGMをメモリから解放 */
	public static void bgmUnloadAll(){
		for(int i=0; i<bgm.length; i++)
			if(bgm[i]!=null){
				bgm[i].stop();
				if(WordSlicker.propConfig.getProperty("option.bgmpreload", false)==false) bgm[i]=null;
			}
	}
}
