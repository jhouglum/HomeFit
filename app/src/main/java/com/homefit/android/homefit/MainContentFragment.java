package com.homefit.android.homefit;


import android.app.Activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainContentFragment extends Fragment implements AdapterView.OnItemClickListener {

	private OnNewItemAddedListener mOnNewItemAddedListener;


	public interface OnNewItemAddedListener {
		void OnNewItemAdded(String newItem);
	}

	public MainContentFragment() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main_content, container, false);
	}

	/*


		final EditText mEditText = (EditText) view.findViewById(R.id.fragment_main_content);


		mEditText.setOnKeyListener(new View.OnKeyListener() {
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN)
					if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
						String newItem = mEditText.getText().toString();
						mEditText.setText("");
						return true;
					}
				return false;
			}
		});
		return view;
	} */

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mOnNewItemAddedListener = (OnNewItemAddedListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString() +
				"must implement OnNewItemAddedListener");
		}
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ListView contentListView = (ListView) getActivity()
							.findViewById(R.id.list_view_main_cont_frag);
		ArrayAdapter tempContentAA = ArrayAdapter.createFromResource(
						getActivity(), R.array.dummy_test_data_item1,
						android.R.layout.simple_list_item_1);
		contentListView.setAdapter(tempContentAA);
		contentListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}