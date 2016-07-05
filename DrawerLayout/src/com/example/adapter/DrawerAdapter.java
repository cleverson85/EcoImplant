package com.example.adapter;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DrawerAdapter extends BaseAdapter {

	private MainActivity mainActivity;
	
	public DrawerAdapter(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View view = mainActivity.getLayoutInflater().inflate(R.layout.fragment_contatos, null);
		
		//TextView text = (TextView) view.findViewById(R.id.textView1);
		//ListView list = (ListView) view.findViewById(R.layout.fragment_contatos_lista); 
		
		//ImageView ico = (ImageView) view.findViewById(R.id.imageView1);
		//ico.setImageResource(((ListaModelo)item.get(position)).getIdImag());
		
		return view;
	}
}
