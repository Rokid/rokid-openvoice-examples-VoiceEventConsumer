package com.rokid.example.vsysdev;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.util.Log;

public class VoiceEventHandler extends BroadcastReceiver {
	public VoiceEventHandler(Context ctx) {
		if (ctx != null) {
			IntentFilter filter = new IntentFilter();
			filter.addAction(TTS_PLAY_ACTION);
			filter.addAction(TTS_STOP_ACTION);
			ctx.registerReceiver(this, filter);
		}
	}

	public void handle(Intent intent) {
		String strExtra;
		double floatExtra;
		int intExtra;

		if (intent == null)
			return;
		if (intent.hasExtra("rklocation")) {
			floatExtra = intent.getDoubleExtra("rklocation", 0.0);
			Log.i(TAG, "本地唤醒，语音方向: " + floatExtra);
			return;
		}
		if (intent.hasExtra("rkpower")) {
			floatExtra = intent.getDoubleExtra("rkpower", 0.0);
			Log.i(TAG, "音强: " + floatExtra);
			return;
		}
		strExtra = intent.getStringExtra("rkactivation");
		if (strExtra != null) {
			Log.i(TAG, "服务端确认唤醒，激活结果: " + strExtra);
			return;
		}
		strExtra = intent.getStringExtra("rkasr_inter");
		if (strExtra != null) {
			Log.i(TAG, "asr识别中间结果: " + strExtra);
			return;
		}
		strExtra = intent.getStringExtra("rkasr");
		if (strExtra != null) {
			Log.i(TAG, "asr识别结果: " + strExtra);
			return;
		}
		strExtra = intent.getStringExtra("rknlp");
		if (strExtra != null) {
			String nlp = strExtra;
			String action = intent.getStringExtra("rkaction");
			Log.i(TAG, "识别结果:\nnlp " + nlp + "\naction " + action);
			return;
		}
		if (intent.hasExtra("rkexception")) {
			intExtra = intent.getIntExtra("rkexception", 0);
			Log.i(TAG, "异常 " + intExtra + ": " + intent.getStringExtra("msg"));
			return;
		}
	}

	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(TTS_PLAY_ACTION)) {
			Log.i(TAG, "tts开始播放");
		}
		if (intent.getAction().equals(TTS_STOP_ACTION)) {
			Log.i(TAG, "tts停止播放");
		}
	}

	private static final String TAG = "RKVoiceEventConsumer";
	private static final String TTS_PLAY_ACTION = "rokid.tts.play";
	private static final String TTS_STOP_ACTION = "rokid.tts.stop";
}
