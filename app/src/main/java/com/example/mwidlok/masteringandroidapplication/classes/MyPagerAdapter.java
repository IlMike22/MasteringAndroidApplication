package com.example.mwidlok.masteringandroidapplication.classes;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import layout.ListFragment;
import layout.ContactFragment;
import layout.SettingsFragment;

/**
 * Created by MWidlok on 20.01.2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

	public MyPagerAdapter(FragmentManager fm)
	{
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch(position)
		{
			case 0:
				return new ListFragment();
			case 1:
				return new ContactFragment();
			case 2:
				return new SettingsFragment();
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {

		switch(position)
		{
			case 0:
				return "Übersicht";
			case 1:
				return "Kontakt";
			case 2:
				return "Einstellungen";
			default:
				return null;
		}
	}
}
