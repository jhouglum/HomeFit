package com.homefit.android.homefit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity /*implements Communicator*/	{

	private String NAV_FRAGMENT = "fragment_main_navigation";
	private String CONTENT_FRAGMENT = "fragment_main_content";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Navigation Fragment.
		FragmentManager navFm = getSupportFragmentManager();
		Fragment navFrag = navFm.findFragmentById(R.id.fragment_main_nav);
		FragmentTransaction navFragTrans = navFm.beginTransaction();
		navFragTrans.add(R.id.fragment_main_nav_bar, navFrag, NAV_FRAGMENT);
		navFragTrans.commit();
		// Content Fragment.
		FragmentManager contentFm = getSupportFragmentManager();
		Fragment contentFrag = contentFm.findFragmentById(R.id.fragment_main_content);
		FragmentTransaction conentFragTrans = contentFm.beginTransaction();
		conentFragTrans.add(R.id.fragment_main_content, contentFrag, CONTENT_FRAGMENT);
		conentFragTrans.commit();

	}

/*	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
	}*/

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

/*	@Override
	public void respond(int i) {
		respond(i);
	}*/

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_tb_main_nav, menu);
		return true;
	}*/

/*	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.log_off_menu_item) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
/*
	public void onClick(View view) {
		Intent intent = new Intent(MainActivity.this, LoginActivity.class);
		startActivity(intent);
	}
*/
/*	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		super.onPanelClosed(featureId, menu);
	}*/

/*	@Override
	public void onDetachedFromWindow() {
		super.onDetachedFromWindow();
	}*/

/*	@Override
	public void onOptionsMenuClosed(Menu menu) {
		super.onOptionsMenuClosed(menu);
	}*/
}
