package com.rokid.example.vsysdev;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

public class RKVoiceEventConsumerService extends Service {
	@Override
	public void onCreate() {
		voiceEventHandler = new VoiceEventHandler(null);
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		voiceEventHandler.handle(intent);
		return START_NOT_STICKY;
	}

	private VoiceEventHandler voiceEventHandler;
}
