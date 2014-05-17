package com.teamramrod.secretdecoder;

import android.app.Application;

public class SecretDecoderApplication extends Application {
	private static Application mInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
	}

	public static Application getApplication() {
		return mInstance;
	}
}
