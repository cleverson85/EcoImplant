package com.example.drawerlayout;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity implements Runnable {

	@Override
	public void onCreate( final Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);

		final Handler handler = new Handler();
		handler.postDelayed(this, 2300);
	}

	public void run() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
}
