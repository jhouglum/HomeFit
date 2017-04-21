package com.homefit.android.homefit;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Communicator,
	MainContentFragment.OnNewItemAddedListener {

	private ArrayAdapter<String> mainContentAdapter;
	private ArrayList<String> mainConentArray;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Navigation Fragment.
		FragmentManager navFm = getSupportFragmentManager();
		MainNavFragment navFrag = (MainNavFragment)navFm
								.findFragmentById(R.id.fragment_main_nav);
		android.support.v4.app.Fragment navigationFragment
								=	navFm.findFragmentById(R.id.fragment_main_nav);

/*		FragmentManager contentFm = getSupportFragmentManager();
		MainContentFragment contentFrag = (MainContentFragment) contentFm
							.findFragmentById(R.id.fragment_main_content);*/
	}



	@Override
	public void respond(int i) {
		respond(i);
	}

	@Override
	public void OnNewItemAdded(String newItem) {
		mainConentArray.add(newItem);
		mainContentAdapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_tb_main_nav, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.log_off_menu_item) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View view) {
		Intent intent = new Intent(MainActivity.this, LoginActivity.class);
		startActivity(intent);
	}
}
