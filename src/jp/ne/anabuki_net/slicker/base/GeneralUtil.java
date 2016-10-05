/* Copyright (c) 2010, NullNoname
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of NullNoname nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE. */
package jp.ne.anabuki_net.slicker.base;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.log4j.Logger;

/** Generic static utils */
public class GeneralUtil{
	/** Log */
	static Logger log=Logger.getLogger(GeneralUtil.class);

	/** Converts play time into a String
	 * @param t Play time
	 * @return String for play time */
	public static String getTime(int t){
		if(t<0) return "--:--.--";

		return String.format("%02d:%02d.%02d", t/3600, t/60%60, t%60*5/3);
	}

	/** Returns ON if b is true, OFF if b is false
	 * @param b Boolean variable to be checked
	 * @return ON if b is true, OFF if b is false */
	public static String getONorOFF(boolean b){
		if(b==true) return "ON";
		return "OFF";
	}

	/** Returns ○ if b is true, × if b is false
	 * @param b Boolean variable to be checked
	 * @return ○ if b is true, × if b is false */
	public static String getOorX(boolean b){
		if(b==true) return "c";
		return "e";
	}

	/** Fetches the filename for a replay
	 * @return Replay's filename */
	public static String getReplayFilename(){
		Calendar c=Calendar.getInstance();
		DateFormat dfm=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String filename=dfm.format(c.getTime())+".rep";
		return filename;
	}

	/** Get date and time from a Calendar
	 * @param c Calendar
	 * @return Date and Time String */
	public static String getCalendarString(Calendar c){
		DateFormat dfm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dfm.format(c.getTime());
	}

	/** Get date and time from a Calendar with specific TimeZone
	 * @param c Calendar
	 * @param z TimeZone
	 * @return Date and Time String */
	public static String getCalendarString(Calendar c, TimeZone z){
		DateFormat dfm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dfm.setTimeZone(z);
		return dfm.format(c.getTime());
	}

	/** Get date from a Calendar
	 * @param c Calendar
	 * @return Date String */
	public static String getCalendarStringDate(Calendar c){
		DateFormat dfm=new SimpleDateFormat("yyyy-MM-dd");
		return dfm.format(c.getTime());
	}

	/** Get date from a Calendar with specific TimeZone
	 * @param c Calendar
	 * @param z TimeZone
	 * @return Date String */
	public static String getCalendarStringDate(Calendar c, TimeZone z){
		DateFormat dfm=new SimpleDateFormat("yyyy-MM-dd");
		dfm.setTimeZone(z);
		return dfm.format(c.getTime());
	}

	/** Get time from a Calendar
	 * @param c Calendar
	 * @return Time String */
	public static String getCalendarStringTime(Calendar c){
		DateFormat dfm=new SimpleDateFormat("HH:mm:ss");
		return dfm.format(c.getTime());
	}

	/** Get time from a Calendar with specific TimeZone
	 * @param c Calendar
	 * @param z TimeZone
	 * @return Time String */
	public static String getCalendarStringTime(Calendar c, TimeZone z){
		DateFormat dfm=new SimpleDateFormat("HH:mm:ss");
		dfm.setTimeZone(z);
		return dfm.format(c.getTime());
	}

	/** Export a Calendar to a String for saving/sending. TimeZone is always GMT.
	 * Time is based on current time.
	 * @return Calendar String (Each field is separated with a hyphen '-') */
	public static String exportCalendarString(){
		Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		return exportCalendarString(c);
	}

	/** Export a Calendar to a String for saving/sending. TimeZone is always GMT.
	 * @param c Calendar
	 * @return Calendar String (Each field is separated with a hyphen '-') */
	public static String exportCalendarString(Calendar c){
		DateFormat dfm=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
		return dfm.format(c.getTime());
	}

	/** Create a Calendar by using a String that came from exportCalendarString.
	 * TimeZone is always GMT.
	 * @param s String (Each field is separated with a hyphen '-')
	 * @return Calendar (null if fails) */
	public static Calendar importCalendarString(String s){
		DateFormat dfm=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		dfm.setTimeZone(TimeZone.getTimeZone("GMT"));

		Calendar c=Calendar.getInstance(TimeZone.getTimeZone("GMT"));

		try{
			Date date=dfm.parse(s);
			c.setTime(date);
		}catch(Exception e){
			return null;
		}

		return c;
	}
	/** Combine array of strings
	 * @param strings Array of strings
	 * @param separator Separator used for combine
	 * @param startIndex First element which will be combined
	 * @return Combined string */
	public static String StringCombine(String[] strings, String separator,
		int startIndex)
	{
		String res="";
		for(int i=startIndex; i<strings.length; i++){
			res+=strings[i];
			if(i!=strings.length-1) res+=separator;
		}

		return res;
	}
}
