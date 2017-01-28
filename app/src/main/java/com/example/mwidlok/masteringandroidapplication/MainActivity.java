package com.example.mwidlok.masteringandroidapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.example.mwidlok.masteringandroidapplication.classes.MyPagerAdapter;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.io.ByteArrayInputStream;

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
		                 .applicationId("aa95d2e5-44b1-43b5-ba51-62aacc28f410")
		                 .server("https://parseapi.back4app.com/")  //hier die richtigen Werte eintragen, dann kann man Daten fetchen
		                 .build()
		);

		Log.i("i","Parse succeeded.");
		byte[] bytes = null;
		ParseFile imgFile = new ParseFile("img.png", bytes);
		ParseObject myParseObject = new ParseObject("JobOffer");
		myParseObject.put("imageLink",imgFile);
		myParseObject.saveInBackground(new SaveCallback() {
			@Override
			public void done(ParseException e) {
				if (e == null)
					Log.i("Info","Parse Upload erfolgreich abgeschlossen");
				else
					Log.e("Error","Parse Upload war leider nicht erfolgreich.");

			}
		});



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
