package jp.ne.anabuki_net.slicker.base;

import java.net.URL;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.newdawn.slick.Sound;

/** Sound effectsマネージャ */
public class SoundManager{
	/** Log */
	static Logger log=Logger.getLogger(SoundManager.class);

	/** 登録できるWAVE file のMaximumcount */
	protected int maxClips;

	/** WAVE file data (Name-> data本体) */
	protected HashMap<String, Sound> clipMap;

	/** 登録されたWAVE file count */
	protected int counter=0;

	/** Constructor */
	public SoundManager(){
		this(128);
	}

	/** Constructor
	 * @param maxClips 登録できるWAVE file のMaximumcount */
	public SoundManager(int maxClips){
		this.maxClips=maxClips;
		clipMap=new HashMap<String, Sound>(maxClips);
	}

	/** Load WAVE file
	 * @param name 登録名
	 * @param filename Filename (String）
	 * @return true if successful, false if failed */
	public boolean load(String name, String filename){
		if(counter>=maxClips){
			log.error("No more wav files can be loaded ("+maxClips+")");
			return false;
		}

		try{
			Sound clip=new Sound(filename);
			clipMap.put(name, clip);
		}catch(Throwable e){
			log.error("Failed to load wav file", e);
			return false;
		}

		return true;
	}

	/** Load WAVE file
	 * @param name 登録名
	 * @param fileurl Filename (URL）
	 * @return true if successful, false if failed */
	public boolean load(String name, URL fileurl){
		if(counter>=maxClips){
			log.error("No more wav files can be loaded ("+maxClips+")");
			return false;
		}

		try{
			Sound clip=new Sound(fileurl);
			clipMap.put(name, clip);
		}catch(Throwable e){
			log.error("Failed to load wav file", e);
			return false;
		}

		return true;
	}

	/** 再生
	 * @param name 登録名 */
	public void play(String name){
		// Nameに対応するクリップを取得
		Sound clip=clipMap.get(name);

		if(clip!=null) clip.play();
	}

	/** 停止
	 * @param name 登録名 */
	public void stop(String name){
		Sound clip=clipMap.get(name);

		if(clip!=null) clip.stop();
	}
}
