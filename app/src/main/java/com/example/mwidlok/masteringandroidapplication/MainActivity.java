package com.example.mwidlok.masteringandroidapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import layout.ContactFragment;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void doSometing()
	{
		Log.i("info", "oh yeah");
		FragmentManager fm = getSupportFragmentManager();
		ContactFragment contactFragment = fm.findFragmentById(R.id.fra)
	}
}
