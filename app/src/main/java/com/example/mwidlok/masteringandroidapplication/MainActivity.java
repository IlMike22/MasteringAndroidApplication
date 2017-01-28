package com.example.mwidlok.masteringandroidapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.mwidlok.masteringandroidapplication.classes.MyPagerAdapter;
import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		Context context = this.getApplicationContext();

		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(adapter);

		Parse.initialize(new Parse.Configuration.Builder(context)
		                 .applicationId("APP_ID")
		                 .server("http://YOUR_PATH_SERVER:1337/parse")  //hier die richtigen Werte eintragen, dann kann man Daten fetchen
		                 .build()
		);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK && getSupportFragmentManager().getBackStackEntryCount() > 1)
		{
			getSupportFragmentManager().popBackStack();
			return true;
		}
		else
			return super.onKeyDown(keyCode, event);
	}
}
