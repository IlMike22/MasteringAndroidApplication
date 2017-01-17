package com.example.mwidlok.masteringandroidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn1 = (Button) findViewById(R.id.btnGo);

		btn1.setOnClickListener(new View.OnClickListener()
		{
			public void onClick(View v)
			{
				doSometing();
			}
		});
	}



	public void doSometing()
	{
		Log.i("info", "oh yeah");
	}
}
