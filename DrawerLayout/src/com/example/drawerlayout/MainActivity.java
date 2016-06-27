package com.example.drawerlayout;

import java.util.ArrayList;

import com.example.adapter.DrawerAdapterSub;
import com.example.fragment.FragmentMain;
import com.example.util.ListaMenu;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ExpandableListView listView;
    private ArrayList item, subItem;
    private boolean isAtive = true;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.item =  (ArrayList) ListaMenu.loadItemMenuSemId();
		this.subItem =  (ArrayList) ListaMenu.loadItemMenuSub();
		
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		listView = (ExpandableListView) findViewById(R.id.left_drawer);
		
		listView.setGroupIndicator(null);
		//listView.setChildIndicator(null);
		
		
		listView.setAdapter(new DrawerAdapterSub(this, item, subItem));
				
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
        
        /*listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView parent, View view, int position, long id) {
				position = ((ListaModelo)item.get(position)).getIdLayout();
				selectedItem(position);
			}
		});*/
	}
	
	protected void selectedItem(int position) {
		android.app.FragmentManager fragTransaction;
		android.app.Fragment frag;
	    
		isAtive = false;
		if(position == R.layout.activity_main){
			isAtive = true;
		}
		
		setFragmentMenu(position);
		changeIconBurguer(true);
		
		listView.setItemChecked(position, true);
		drawerLayout.closeDrawer(listView);
	}

	private void setFragmentMenu(int position) {
		android.app.FragmentManager fragTransaction;
		android.app.Fragment frag;
		
		frag = new FragmentMain(position);
		fragTransaction = getFragmentManager();
		fragTransaction.beginTransaction().replace(R.id.content_frame, frag).commit();
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