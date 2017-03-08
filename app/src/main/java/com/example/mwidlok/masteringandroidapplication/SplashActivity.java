package com.example.mwidlok.masteringandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.mwidlok.masteringandroidapplication.classes.MyAsyncTask;

public class SplashActivity extends AppCompatActivity {

	private final int SPLASH_DURATION = 1000;

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

		try
		{
			ProgressBar pb = (ProgressBar) findViewById(R.id.pbSplash);
			Log.d("Info","Progressbar konnte initialisiert werden.");
			new MyAsyncTask(pb).execute(new Integer[]{10});
		}
		catch(Exception exc)
		{
			Log.e("Error", "Fehler bei der Progressbar");
		}
	}


	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		super.overridePendingTransition(enterAnim, exitAnim);
	}
}
