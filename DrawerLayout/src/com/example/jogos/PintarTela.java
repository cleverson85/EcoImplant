package com.example.jogos;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PintarTela extends View {
	
	 private Paint paint = new Paint(); 
     private Path path = new Path();
     
	public PintarTela(Context context) {
		super(context);
	}

	public PintarTela(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		paint.setColor(((ActivityRabiscos)getContext()).getCor());
		paint.setAntiAlias(true); 
        paint.setStrokeWidth(6); 
        paint.setStyle(Paint.Style.STROKE); 
        paint.setStrokeJoin(Paint.Join.ROUND);
	}

	@Override 
	protected void onDraw(Canvas canvas) {
		canvas.drawPath(path, paint);
	}

	@Override
	public boolean onTouchEvent(MotionEvent motionEvent) {
		float eventX = motionEvent.getX();
		float eventY = motionEvent.getY();

		switch (motionEvent.getAction()) {
			case MotionEvent.ACTION_DOWN:
				path.moveTo(eventX, eventY);
				return true;
	
			case MotionEvent.ACTION_MOVE:
				path.lineTo(eventX, eventY);
				break;
	
			default:
				return false;
		}

		invalidate();
		return true;
	}
}
