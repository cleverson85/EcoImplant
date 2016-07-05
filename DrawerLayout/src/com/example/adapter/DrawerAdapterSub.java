package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;
import com.example.modelo.ListaModeloSub;
import com.example.modelo.ModeloGeral;

import android.R.color;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressWarnings("unchecked")
public class DrawerAdapterSub extends BaseExpandableListAdapter {

	public List<ListaModeloSub> itemTemp;
	private final MainActivity mainActivity;
	private ArrayList<ModeloGeral> itemGeral;

	public DrawerAdapterSub(MainActivity mainActivity, ArrayList<ModeloGeral> itemGeral) {
		this.mainActivity = mainActivity;
		this.itemGeral = itemGeral;
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
		try {
			return itemGeral.get(groupPosition).getFilho().size();
		}
		catch(Exception e) {
			return 0;
		}
	}

	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}

	@Override
	public int getGroupCount() {
		return itemGeral.size();
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
		text.setText(itemGeral.get(groupPosition).getPai().getDescricao());
		
		ImageView ico = (ImageView) view.findViewById(R.id.imageView1);
		ico.setImageResource(itemGeral.get(groupPosition).getPai().getIdImag());
		
		if(isExpanded) {
	        view.setBackgroundResource(R.color.group_selected);
	    }
		else {
	        view.setBackgroundColor(color.transparent);
	    }
		
		view.setTag(itemGeral.get(groupPosition));
		return view;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
								final boolean isLastChild, View convertView, ViewGroup parent) {
		
		final View view = mainActivity.getLayoutInflater().inflate(R.layout.text_menu_item, null);
		
		TextView text = (TextView) view.findViewById(R.id.textView2);
		text.setText(itemGeral.get(groupPosition).getFilho().get(childPosition).getDescricao());
		
		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			}
		});
		
		view.setBackgroundResource(R.color.group_selected);
		view.setTag(itemGeral.get(groupPosition).getFilho());
		return view;
	}
}
