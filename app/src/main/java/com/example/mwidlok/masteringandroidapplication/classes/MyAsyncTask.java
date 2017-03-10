package com.example.mwidlok.masteringandroidapplication.classes;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * Created by MWidlok on 06.03.2017.
 */

public class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

	ProgressBar pb;

	public MyAsyncTask(ProgressBar pb)
	{
		this.pb = pb;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pb.setProgress(0);
	}

	@Override
	protected void onProgressUpdate(Integer... params) {
		super.onProgressUpdate(params);
		pb.setProgress(params[0]);
	}

	@Override
	protected Void doInBackground(Integer... params) {
		for (int i = 0; i < 100; i++)
		{
			Log.d("AsyncTask","Round " + i);

			try
			{
				Thread.sleep(100);
			}
			catch(InterruptedException exc)
			{
				exc.printStackTrace();
			}

			publishProgress(i);
		}

		return null;
	}

	@Override
	protected void onPostExecute(Void aVoid) {
		super.onPostExecute(aVoid);
		Log.d("AsyncTask", "Completed");

	}
}
