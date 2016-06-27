package com.example.adapter;

import java.util.ArrayList;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;
import com.example.util.ListaModelo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings("unchecked")
public class DrawerAdapterSub extends BaseExpandableListAdapter {

	public ArrayList<ListaModelo> item, itemTemp;
	public ArrayList<Object> subItem = new ArrayList<Object>();
	public LayoutInflater minflater;
	public Activity activity;
	private final MainActivity mainActivity;

	public DrawerAdapterSub(MainActivity mainActivity, ArrayList<ListaModelo> item, ArrayList<Object> subItem) {
		this.mainActivity = mainActivity;
		this.item = item;
		this.subItem = subItem;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return ((ArrayList<String>) subItem.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}

	@Override
	public int getGroupCount() {
		return item.size();
	}

	@Override
	public void onGroupCollapsed(int groupPosition) {
		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) {
		super.onGroupExpanded(groupPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}
	
	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		View view = mainActivity.getLayoutInflater().inflate(R.layout.text_menu, null);
		
		TextView text = (TextView) view.findViewById(R.id.textView1);
		text.setText(((ListaModelo)item.get(groupPosition)).getDescricao());
		
		ImageView ico = (ImageView) view.findViewById(R.id.imageView1);
		ico.setImageResource(((ListaModelo)item.get(groupPosition)).getIdImag());
		
		view.setTag(item.get(groupPosition));
		
		return view;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		
		itemTemp = (ArrayList<ListaModelo>) subItem.get(groupPosition);
		View view = mainActivity.getLayoutInflater().inflate(R.layout.text_menu_item, null);
		
		TextView text = (TextView) view.findViewById(R.id.textView2);
		text.setText("  " + itemTemp.get(childPosition));
		
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
		view.setTag(item.get(childPosition));
		return view;
	}
}
