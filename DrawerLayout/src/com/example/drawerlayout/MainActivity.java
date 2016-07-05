package com.example.drawerlayout;

import java.util.ArrayList;

import com.example.adapter.DrawerAdapterAnimated;
import com.example.fragment.FragmentMain;
import com.example.jogos.ActivityRabiscos;
import com.example.modelo.ModeloGeral;
import com.example.util.ListaMenu;
import com.example.videos.ActivityVideosOuseUseActivity;
import com.example.videos.ActivityVideosReutilizar;
import com.example.videos.VideosActivity;
import com.example.widget.AnimatedExpandableListView;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private AnimatedExpandableListView listView;
    private ArrayList listaGeral;
    private boolean isAtive = true;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
			
		loadDrawerLayout();
	}
	
	public static void hideSoftKeyboard(Activity activity) {
	    InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
	    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		isAtive = true;
		setFragmentMenu(R.layout.activity_main);
	}
	
	protected void loadDrawerLayout() {
		
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		listView = (AnimatedExpandableListView) findViewById(R.id.left_drawer);

		listaGeral = new ListaMenu().getGrupo();
		listView.setGroupIndicator(null);
		listView.setAdapter(new DrawerAdapterAnimated(this, listaGeral));
				
		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_burguer, 
				R.string.drawer_open, R.string.drawer_close){
			
			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); 		// creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); 		// creates call to onPrepareOptionsMenu()
            }
		};
		
		// Set the drawer toggle as the DrawerListener
		drawerLayout.setDrawerListener(drawerToggle);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false); //retira icone da action bar
                
        listView.setOnGroupClickListener(new OnGroupClickListener() {
        	int groupPositionTemp = 0;
        	
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				
				ModeloGeral m = (ModeloGeral) listaGeral.get(groupPosition);
				
				if(m.getFilho() == null){
					listView.collapseGroupWithAnimation(groupPositionTemp);
					selectedItem(m.getPai().getIdLayout());
				}
				else {
					if (listView.isGroupExpanded(groupPosition)) {
	                    listView.collapseGroupWithAnimation(groupPosition);
	                } 
					else {
	                    listView.expandGroupWithAnimation(groupPosition);
	                    if(listView.isGroupExpanded(groupPositionTemp) && groupPositionTemp != groupPosition){
	                    	listView.collapseGroupWithAnimation(groupPositionTemp);
	                    }
	                }
					groupPositionTemp = groupPosition;
				}
				return true;
			}
		});
        
        listView.setOnChildClickListener(new OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				
				ModeloGeral m = (ModeloGeral) listaGeral.get(groupPosition);
				selectedItem(m.getFilho().get(childPosition).getIdLayout());
				
				return true;
			}
		});
	}
	
	protected void selectedItem(int idLayout) {
		isAtive = false;
		if(idLayout == R.layout.activity_main){
			isAtive = true;
		}
		
		setFragmentMenu(idLayout);
		changeIconBurguer(true);
		
		listView.setItemChecked(idLayout, true);
		drawerLayout.closeDrawer(listView);
	}

	private void setFragmentMenu(int idLayout) {
		android.app.FragmentManager fragTransaction;
		android.app.Fragment frag;
		Intent irPara;
		
		if(idLayout == R.layout.fragment_videos){
			irPara = new Intent(MainActivity.this, VideosActivity.class);
			startActivity(irPara);
		}
		else if(idLayout == R.layout.fragment_ouse_use){
			irPara = new Intent(MainActivity.this, ActivityVideosOuseUseActivity.class);
			startActivity(irPara);
		}
		else if(idLayout == R.layout.fragment_videos_reuse){
			irPara = new Intent(MainActivity.this, ActivityVideosReutilizar.class);
			startActivity(irPara);
		}
		else if(idLayout == R.layout.activity_desenhar){
			irPara = new Intent(MainActivity.this, ActivityRabiscos.class);
			startActivity(irPara);
		}
		else {
			frag = new FragmentMain(idLayout, this);
			fragTransaction = getFragmentManager();
			fragTransaction.beginTransaction().replace(R.id.content_frame, frag).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);	// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			isAtive = false;
			setFragmentMenu(R.layout.fragment_sobre);
		}
		
		drawerToggle.setDrawerIndicatorEnabled(true);
		if (drawerToggle.onOptionsItemSelected(item)) {
			if(!drawerLayout.isDrawerOpen(listView)){
				changeIconBurguer(false);
			}
        }
		
		MainActivity.hideSoftKeyboard(this); 	//hide keyboard 
		
		return super.onOptionsItemSelected(item);
	}
	
	/* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = drawerLayout.isDrawerOpen(listView);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        changeIconBurguer(drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
            changeIconBurguer(true);
        }
        
		if(!isAtive){
			setFragmentMenu(R.layout.activity_main);
			Toast.makeText(this, "Pressione mais uma vez para fechar o aplivativo.", Toast.LENGTH_SHORT).show();
			isAtive = true;
		}
		else {
			super.onBackPressed();
		}
    }
    
    private void changeIconBurguer(boolean change) {
    	if(!change){
        	drawerToggle.setDrawerIndicatorEnabled(true);
            drawerToggle.setHomeAsUpIndicator(R.drawable.ic_burguer);
        } 
        else {
        	drawerToggle.setDrawerIndicatorEnabled(false);
	        drawerToggle.setHomeAsUpIndicator(R.drawable.ic_left_arrow);
        }
    }
}