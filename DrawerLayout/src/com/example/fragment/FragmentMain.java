package com.example.fragment;

import com.example.drawerlayout.R;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMain extends Fragment{
	
	private int layout;
	View view;
	
	public FragmentMain(int layout) {
		this.layout = layout;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		
		view = inflater.inflate(layout, null);
		return view;
	}
}
