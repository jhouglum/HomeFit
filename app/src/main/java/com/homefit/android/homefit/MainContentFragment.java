package com.homefit.android.homefit;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainContentFragment extends Fragment /*ListFragment implements AdapterView.OnItemClickListener*/ {

//	private OnNewItemAddedListener mOnNewItemAddedListener;
	private ListView mContentList;
	private EditText mEditText;

/*	public interface OnNewItemAddedListener {
		void OnNewItemAdded(String newItem);
	} */

/*	public MainContentFragment() {
		super();
	}*/

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
	/*	mContentList inflater.inflate(R.layout.fragment_main_content, container, false);
						mEditText =
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
		}); */
		return inflater.inflate(R.layout.fragment_main_content, container, false);
	}

/*	@Override
	public void onAttach(Context context) {
		super.onAttach(context);

		try {
			mOnNewItemAddedListener = (OnNewItemAddedListener) context;
		} catch (ClassCastException e) {
			throw new ClassCastException(context.toString() +
				"must implement OnNewItemAddedListener");
		}
	}*/


	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ListView contentListView = (ListView) getActivity()
							.findViewById(R.id.list_view_main_cont);
		ArrayAdapter tempContentAA = ArrayAdapter.createFromResource(
			getActivity(), R.array.dummy_test_data_item1,
			android.R.layout.simple_list_item_1);
		contentListView.setAdapter(tempContentAA);

//		contentListView.setOnItemClickListener(this);
	}

/*	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

	}*/

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
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
	public void onDestroyView() {
		super.onDestroyView();
	}
}