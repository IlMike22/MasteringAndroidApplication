package com.example.mwidlok.masteringandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

	private final int SPLASH_DURATION = 1500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		new Handler().postDelayed(new Runnable()
		{
			@Override
			public void run() {
				Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
				SplashActivity.this.startActivity(mainIntent);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
				SplashActivity.this.finish();
			}
		}, SPLASH_DURATION);
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		super.overridePendingTransition(enterAnim, exitAnim);
	}
}
