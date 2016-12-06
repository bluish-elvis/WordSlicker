
package jp.ne.anabuki_net.slicker.gui;

/** 各種エフェクト state */
public class EffectObject{
	/** エフェクト type */
	public int effect;

	/** X-coordinate */
	public int x;

	/** Y-coordinate */
	public int y;

	/** エフェクトのパラメータ (Block colorなど) */
	public int param;

	/** アニメーション counter */
	public int anim;

	/** Constructor */
	public EffectObject(){
		effect=0;
		x=0;
		y=0;
		param=0;
		anim=0;
	}

	/** パラメータ付きConstructor
	 * @param effect エフェクト type
	 * @param x X-coordinate
	 * @param y Y-coordinate
	 * @param param エフェクトのパラメータ (Block colorなど） */
	public EffectObject(int effect, int x, int y, int param){
		this.effect=effect;
		this.x=x;
		this.y=y;
		this.param=param;
		anim=0;
	}

	/** Copy constructor
	 * @param src Copy source */
	public EffectObject(EffectObject src){
		effect=src.effect;
		x=src.x;
		y=src.y;
		param=src.param;
		anim=src.anim;
	}
}
