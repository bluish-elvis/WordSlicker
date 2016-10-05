package jp.ne.anabuki_net.slicker.base;

import java.io.Serializable;

/** 音楽の再生状況を管理するクラス */
public class BGMStatus implements Serializable{
	/** Serial version ID */
	private static final long serialVersionUID=-1003092972570497408L;

	/** 音楽の定count */
	public static final int BGM_NOTHING=-1;

	/** Current BGM number */
	public int bgm;

	/** 音量 (1f=100%, 0.5f=50%) */
	public float volume;

	/** BGM fadeoutスイッチ */
	public boolean fadesw;

	/** Constructor */
	public BGMStatus(){
		reset();
	}

	/** Copy constructor
	 * @param b Copy source */
	public BGMStatus(BGMStatus b){
		copy(b);
	}

	/** Reset to defaults */
	public void reset(){
		bgm=BGM_NOTHING;
		volume=1f;
		fadesw=false;
	}

	/** 他のBGMStatusからコピー
	 * @param b Copy source */
	public void copy(BGMStatus b){
		bgm=b.bgm;
		volume=b.volume;
		fadesw=b.fadesw;
	}

	/** BGM fade状態と音量の更新 */
	public void fadeUpdate(){
		if(fadesw==true){
			if(volume>0f) volume-=0.005f;
			else if(volume<0f) volume=0f;
		}else if(volume<1f) volume=1f;
	}
}

