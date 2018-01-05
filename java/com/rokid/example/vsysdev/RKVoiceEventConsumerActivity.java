package com.rokid.example.vsysdev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RKVoiceEventConsumerActivity extends Activity {
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		voiceEventHandler = new VoiceEventHandler();
		voiceEventHandler.handle(getIntent());
	}

	public void onNewIntent(Intent intent) {
		voiceEventHandler.handle(intent);
	}

	private VoiceEventHandler voiceEventHandler;
}
