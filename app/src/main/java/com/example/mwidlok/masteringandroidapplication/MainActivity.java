package com.example.mwidlok.masteringandroidapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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

	public ParseQueryAdapter<JobOffer> parseQueryAdapter = null;

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

		// Using GoogleVolley

		String url = "http://www.google.de";   // setup test uri
		RequestQueue queue = Volley.newRequestQueue(this); // create volley Request Queue

		// Creating String Request with Handlers.

		StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				Log.d("volley", "response is " + response.substring(500));
			}
		},new Response.ErrorListener()
			{
				public void onErrorResponse(VolleyError error)
				{
					Log.d("Volley","Sorry that didn't work");
				}
			});

		// now the String Request has to be add to the Volley Queue
		queue.add(stringRequest);

		// now using OKHttp (or better saying combining Google Volley and OKHttp)

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
