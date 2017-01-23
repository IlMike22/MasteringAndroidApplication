package com.example.mwidlok.masteringandroidapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.example.mwidlok.masteringandroidapplication.classes.MyPagerAdapter;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(adapter);
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
