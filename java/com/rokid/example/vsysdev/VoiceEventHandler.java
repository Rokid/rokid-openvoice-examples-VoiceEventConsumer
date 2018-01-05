package com.rokid.example.vsysdev;

import android.content.Intent;
import android.util.Log;

public class VoiceEventHandler {
	public void handle(Intent intent) {
		String strExtra;
		double floatExtra;
		int intExtra;

		if (intent == null)
			return;
		if (intent.hasExtra("rklocation")) {
			floatExtra = intent.getDoubleExtra("rklocation", 0.0);
			Log.i(TAG, "语音方向: " + floatExtra);
			return;
		}
		if (intent.hasExtra("rkpower")) {
			floatExtra = intent.getDoubleExtra("rkpower", 0.0);
			Log.i(TAG, "音强: " + floatExtra);
			return;
		}
		strExtra = intent.getStringExtra("rkactivation");
		if (strExtra != null) {
			Log.i(TAG, "激活结果: " + strExtra);
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

	private static final String TAG = "RKVoiceEventConsumer";
}
