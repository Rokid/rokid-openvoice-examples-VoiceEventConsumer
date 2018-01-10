package com.rokid.example.vsysdev;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.IBinder;
import com.rokid.voicerec.BearKid;

public class RKVoiceEventConsumerActivity extends Activity implements ServiceConnection {
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		voiceEventHandler = new VoiceEventHandler(getApplicationContext());
		voiceEventHandler.handle(getIntent());

		connectBearKid();
	}

	public void onNewIntent(Intent intent) {
		voiceEventHandler.handle(intent);
	}

	private void connectBearKid() {
		bearKid = null;
		Intent intent = new Intent();
		intent.setComponent(new ComponentName(BEARKID_PACKAGE, BEARKID_CLASS_NAME));
		getApplicationContext().bindService(intent, this, BIND_AUTO_CREATE);
	}

	public void onServiceConnected(ComponentName name, IBinder binder) {
		bearKid = BearKid.Stub.asInterface(binder);
	}

	public void onServiceDisconnected(ComponentName name) {
		bearKid = null;
	}

	// 禁麦
	private void mute() {
		try {
			if (bearKid != null)
				bearKid.control(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 开始拾音
	private void active() {
		try {
			if (bearKid != null)
				bearKid.control(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 停止拾音
	private void deactive() {
		try {
			if (bearKid != null)
				bearKid.control(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private VoiceEventHandler voiceEventHandler;
	private BearKid bearKid;

	private static final String BEARKID_PACKAGE = "com.rokid.openvoice";
	private static final String BEARKID_CLASS_NAME = "com.rokid.voicerec.BearKid";
}
