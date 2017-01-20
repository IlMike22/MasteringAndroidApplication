package com.example.mwidlok.masteringandroidapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import layout.ContactFragment;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ContactFragment contactFragment = ContactFragment.newInstance();
		getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, contactFragment).commit();
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
