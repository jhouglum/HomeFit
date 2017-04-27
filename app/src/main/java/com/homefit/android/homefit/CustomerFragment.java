package com.homefit.android.homefit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

public class CustomerFragment extends Fragment {

	private static final String ARG_CUSTOMER_ID = "customer_id";

	private Customer mCustomer;
	private EditText mNameET;
	private EditText mAddrOneET;
	private EditText mAddrTwoET;
	private EditText mCityET;
	private EditText mStateET;
	private EditText mZipET;
	private EditText mPhoneET;

	public static CustomerFragment newInstance(UUID customerId) {
		Bundle args = new Bundle();
		args.putSerializable(ARG_CUSTOMER_ID, customerId);

		CustomerFragment fragment = new CustomerFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID customerId = (UUID) getArguments().getSerializable(ARG_CUSTOMER_ID);
		mCustomer = CustomerList.getCustomer(getActivity()).getCustomer(customerId);
	}

	@Override
	public void onPause() {
		super.onPause();

		CustomerList.getCustomer(getActivity())
			.updateCustomer(mCustomer);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_customer, container, false);

		mNameET = (EditText) v.findViewById(R.id.customer_name);
		mNameET.setText(mCustomer.getName());
		mNameET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setName(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mAddrOneET = (EditText) v.findViewById(R.id.customer_address_one);
		mAddrOneET.setText(mCustomer.getAddrOne());
		mAddrOneET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setAddrOne(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mAddrTwoET = (EditText) v.findViewById(R.id.customer_address_two);
		mAddrTwoET.setText(mCustomer.getAddrTwo());
		mAddrTwoET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setAddrTwo(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mCityET = (EditText) v.findViewById(R.id.customer_city);
		mCityET.setText(mCustomer.getCity());
		mCityET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setCity(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mStateET = (EditText) v.findViewById(R.id.customer_state);
		mStateET.setText(mCustomer.getState());
		mStateET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setState(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mZipET = (EditText) v.findViewById(R.id.customer_zip);
		mZipET.setText(mCustomer.getZip());
		mZipET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setZip(s.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		mPhoneET = (EditText) v.findViewById(R.id.customer_phone);
		mPhoneET.setText(mCustomer.getPhone());
		mPhoneET.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCustomer.setPhone(s.toString());
			}
			@Override
			public void afterTextChanged(Editable s) {
			}
		});

		return v;
	}
}