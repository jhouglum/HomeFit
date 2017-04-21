package com.homefit.android.homefit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainNavFragment extends Fragment {

	private View.OnClickListener onClickListener;

	Toolbar mNavToolBar;
	Button mNavButtonSessions;
	Button mNavButtonCustomers;
	Button navmNavButtonBilling;
	RelativeLayout navRelLayout;
	Communicator navCommunicator;

	public interface OnClickListener {
		void onClickView();
	}

	public MainNavFragment() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {

		navCommunicator = (Communicator) getActivity();
		navRelLayout = (RelativeLayout) getActivity().findViewById(R.id.fragment_main_nav);
		inflater.inflate(R.layout.fragment_main_content, container, true);
		/*
		mNavToolBar = (Toolbar) getActivity().findViewById(R.id.main_nav_toolbar);
		mNavToolBar.inflateMenu(R.menu.menu_tb_main_nav);
		mNavButtonSessions = (Button) getActivity().findViewById(R.id.nav_button_session);
		mNavButtonCustomers = (Button) getActivity().findViewById(R.id.nav_button_customers);
		navmNavButtonBilling = (Button) getActivity().findViewById(R.id.nav_button_billing);*/


/*		mNavButtonSessions.OnClickListener(new View.OnClickListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
						Intent intent = new Intent();
						intent.get
						return true;
					}
				return false;
			}
		}); */
		return navRelLayout;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			View.OnClickListener onClickListener = (View.OnClickListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() +
				"must implement OnClickListener");
		}
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
