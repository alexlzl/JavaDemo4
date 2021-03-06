package cn.bluerhino.driver.utils;

import android.content.Context;
import android.media.AudioManager;

public class AudioManagerUtil {

	/**
	 * 设置媒体音量为最大值
	 * @param cxt
	 */
	public static void setStreamMusicMaxVolume(Context cxt) {
		setStreamMaxVolume(cxt, AudioManager.STREAM_MUSIC);
	}

	public static void setStreamMaxVolume(Context cxt, int streamType) {
		AudioManager am = (AudioManager) cxt
				.getSystemService(Context.AUDIO_SERVICE);
		am.setStreamVolume(streamType, am.getStreamMaxVolume(streamType), 0);
	}

}
