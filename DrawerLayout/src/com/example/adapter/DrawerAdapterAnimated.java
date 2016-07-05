package com.example.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.drawerlayout.MainActivity;
import com.example.drawerlayout.R;
import com.example.fragment.FragmentMain;
import com.example.modelo.ListaModeloSub;
import com.example.modelo.ModeloGeral;
import com.example.widget.AnimatedExpandableListView.AnimatedExpandableListAdapter;

import android.R.color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class DrawerAdapterAnimated extends AnimatedExpandableListAdapter {

	public List<ListaModeloSub> itemTemp;
	private final MainActivity mainActivity;
	private ArrayList<ModeloGeral> itemGeral;
	
	public DrawerAdapterAnimated(MainActivity mainActivity, ArrayList<ModeloGeral> itemGeral) {
		super();
		this.mainActivity = mainActivity;
		this.itemGeral = itemGeral;
	}
	
	@Override
	public int getGroupCount() {
		return itemGeral.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return itemGeral.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return itemGeral.get(groupPosition).getFilho().get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	@Override
	public int getRealChildrenCount(int groupPosition) {
		try {
			return itemGeral.get(groupPosition).getFilho().size();
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		
		View view = mainActivity.getLayoutInflater().inflate(R.layout.text_menu, null);
		
		TextView text = (TextView) view.findViewById(R.id.textView1);
		text.setText(itemGeral.get(groupPosition).getPai().getDescricao());
		
		ImageView ico = (ImageView) view.findViewById(R.id.imageView1);
		ico.setImageResource(itemGeral.get(groupPosition).getPai().getIdImag());
		
		if(getRealChildrenCount(groupPosition) > 0) {
			ImageView img = (ImageView) view.findViewById(R.id.imageView2);
			int imageResourceId = isExpanded ? R.drawable.ic_action_collapse
                    : R.drawable.ic_action_expand;
			img.setImageResource(imageResourceId);
		}
		
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
	public View getRealChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		
		final View view = mainActivity.getLayoutInflater().inflate(R.layout.text_menu_item, null);
		
		TextView text = (TextView) view.findViewById(R.id.textView2);
		text.setText(itemGeral.get(groupPosition).getFilho().get(childPosition).getDescricao());
		
		view.setTag(itemGeral.get(groupPosition).getFilho());
		return view;
	}
}
