package com.example.jogos;

import com.example.drawerlayout.R;
import com.example.drawerlayout.R.id;
import com.example.drawerlayout.R.layout;
import com.example.drawerlayout.R.menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ActivityRabiscos extends Activity {
	
	private ColorDrawable corButton;	
	private int cor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rabiscos);
		
		final Button b = (Button) findViewById(R.id.btCor);
					
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				corButton = (ColorDrawable) b.getBackground();
				switch (corButton.getColor()) {
					case Color.BLACK: 
						b.setBackgroundColor(Color.RED);
						setCor(Color.RED);
						break;
						
					case Color.RED: 
						b.setBackgroundColor(Color.BLUE);
						setCor(Color.BLUE);
						break;
						
					case Color.BLUE: 
						b.setBackgroundColor(Color.YELLOW);
						setCor(Color.YELLOW);
						break;
						
					case Color.YELLOW: 
						b.setBackgroundColor(Color.GREEN);
						setCor(Color.GREEN);
						break;
						
					case Color.GREEN: 
						b.setBackgroundColor(Color.GRAY);
						setCor(Color.GRAY);
						break;
						
					case Color.GRAY: 
						b.setBackgroundColor(Color.DKGRAY);
						setCor(Color.DKGRAY);
						break;
						
					case Color.DKGRAY: 
						b.setBackgroundColor(Color.MAGENTA);
						setCor(Color.MAGENTA);
						break;
						
					default:
						b.setBackgroundColor(Color.BLACK);
						setCor(Color.BLACK);
						break;
					}
			}
		});
	}
	
	public int getCor(){
		return cor;
	}
	
	public void setCor(int cor){
		this.cor = cor;
	}
}
