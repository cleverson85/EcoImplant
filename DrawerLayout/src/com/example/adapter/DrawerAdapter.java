package com.example.adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter{

	private MainActivity mainActivity;
	private TreeMap<Integer, String> item;
	
	public DrawerAdapter(MainActivity main, TreeMap<Integer, String> item) {
		this.mainActivity = main;
		this.item = item;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return item.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return item.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View view = mainActivity.getLayoutInflater().inflate(R.layout.text_menu, null);
		
		TextView text = (TextView) view.findViewById(R.id.textView1);
		text.setText(item.values().toArray()[position].toString());
		
		ImageView ico = (ImageView) view.findViewById(R.id.imageView1);
		ico.setImageResource(R.drawable.ic_location);
		
		return view;
	}

}
