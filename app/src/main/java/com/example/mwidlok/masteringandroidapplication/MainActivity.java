package com.example.mwidlok.masteringandroidapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mwidlok.masteringandroidapplication.classes.JobOffer;
import com.example.mwidlok.masteringandroidapplication.classes.MyPagerAdapter;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
		Context context = this.getApplicationContext();

		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(adapter);

		// registering jobOffer class for easier data handling
		ParseObject.registerSubclass(JobOffer.class);

		Parse.initialize(new Parse.Configuration.Builder(context)
		                 .applicationId("ynaFJV6UB6rMTNAuWNY5LFEf1xmVWnH0CAAvKTiz")
				         .clientKey("UvZYfT1qo0IytlZwYm58zOXu2HGU2YbK28eQDB7A")
		                 .server("https://parseapi.back4app.com/")  //hier die richtigen Werte eintragen, dann kann man Daten fetchen
		                 .build()
		);

		// Consuming data from parse...

		ParseQuery<JobOffer> query = ParseQuery.getQuery("JobOffer");
		query.whereEqualTo("type","unbefristeter AP");

		query.findInBackground(new FindCallback<JobOffer>() {
			                       @Override
			                       public void done(List<JobOffer> jobOfferList, ParseException e) {
									 if (e == null)
									 {
										 Log.d("ParseInfo","Retrieved " + jobOfferList.size() + " Jobs");
										 Log.d("ParseInfo","Title " + jobOfferList.get(0).getTitle());
									 }
				                       else
										 Log.e("ParseInfo","Failed to load JobOfferList. Details: " + e.getMessage());
			                       }
		                       });

		ParseQueryAdapter<JobOffer> parseQueryAdapter = new ParseQueryAdapter<JobOffer>(this,"JobOffer")
		{
			@Override
			public View getItemView(JobOffer jobOffer, View v, ViewGroup parent) {

				if (v == null)
				{
					v = View.inflate(getContext(), R.layout.row_job_offer, null);
				}
				super.getItemView(jobOffer, v, parent);

				TextView tvTitle = (TextView) v.findViewById(R.id.rowJobOfferTitle);
				tvTitle.setText(jobOffer.getTitle());
				TextView tvDescription = (TextView) v.findViewById(R.id.rowJobOfferDesc);
				tvDescription.setText(jobOffer.getDescription());

				return v;
			}
		};


		                       // Storing data to parse...
//		ParseObject myParseObject = new ParseObject("JobOffer");
//		myParseObject.put("title","Group Leader Android Developer");
//		myParseObject.put("description","Du hast langjährige Erfahrung in der Android Entwicklung und hast auch schon ein kleines Team unter dir gehabt, das für dich gearbeitet hat.");
//		myParseObject.put("salary","67.000 Euro");
//		myParseObject.put("company", "MyCompany AG");
//		myParseObject.put("type","unbefristeter AP");
//		myParseObject.put("imageLink","image");
//		myParseObject.put("location","Nürnberg, Bayern");

//		myParseObject.saveInBackground(new SaveCallback() {
//			@Override
//			public void done(ParseException e) {
//				if (e == null)
//					Log.i("Info","Parse Upload erfolgreich abgeschlossen");
//				else
//					Log.e("Error","Parse Upload war leider nicht erfolgreich.");
//
//			}
//		});


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
