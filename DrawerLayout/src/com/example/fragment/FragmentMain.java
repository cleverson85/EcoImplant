package com.example.fragment;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;
import com.example.widget.FragmentInflatorFactory;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentMain extends Fragment {
	
	private int layout;
	private MainActivity mainActivity;
	
	public FragmentMain(int layout, MainActivity mainActivity) {
		this.layout = layout;
		this.mainActivity = mainActivity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
		return mainActivity.getLayoutInflater().inflate(layout, null);
	}
}
