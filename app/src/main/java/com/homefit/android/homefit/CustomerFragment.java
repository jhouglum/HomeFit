package com.homefit.android.homefit;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
	private EditText mEmailET;
	private Button mSaveButton;
	private Button mDeleteButton;

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
	}

	@Override
	public void onPause() {
		super.onPause();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_customer, container, false);

		UUID customerId = (UUID) getArguments().getSerializable(ARG_CUSTOMER_ID);
		mCustomer = CustomerList.getCustomer(getActivity()).getCustomer(customerId);

		mNameET = (EditText) v.findViewById(R.id.customer_name);
		mNameET.setText(mCustomer.getName());

		mAddrOneET = (EditText) v.findViewById(R.id.customer_address_one);
		mAddrOneET.setText(mCustomer.getAddrOne());

		mAddrTwoET = (EditText) v.findViewById(R.id.customer_address_two);
		mAddrTwoET.setText(mCustomer.getAddrTwo());

		mCityET = (EditText) v.findViewById(R.id.customer_city);
		mCityET.setText(mCustomer.getCity());

		mStateET = (EditText) v.findViewById(R.id.customer_state);
		mStateET.setText(mCustomer.getState());

		mZipET = (EditText) v.findViewById(R.id.customer_zip);
		mZipET.setText(mCustomer.getZip());

		mPhoneET = (EditText) v.findViewById(R.id.customer_phone);
		mPhoneET.setText(mCustomer.getPhone());

		mEmailET = (EditText) v.findViewById(R.id.customer_email);
		mEmailET.setText(mCustomer.getEmail());

		mSaveButton = (Button) v.findViewById(R.id.customer_save_button);
		mSaveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCustomer.setName(mNameET.getText().toString());
				mCustomer.setAddrOne(mAddrOneET.getText().toString());
				mCustomer.setAddrTwo(mAddrTwoET.getText().toString());
				mCustomer.setCity(mCityET.getText().toString());
				mCustomer.setState(mStateET.getText().toString());
				mCustomer.setZip(mZipET.getText().toString());
				mCustomer.setPhone(mPhoneET.getText().toString());
				mCustomer.setEmail(mEmailET.getText().toString());

				Toast.makeText(getActivity(), R.string.customer_add_bttn_toast,
							Toast.LENGTH_SHORT).show();
				CustomerList.getCustomer(getActivity()).updateCustomer(mCustomer);
				getActivity().finish();
			}
		});

		mDeleteButton = (Button) v.findViewById(R.id.customer_delete_button);
		mDeleteButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CustomerList.getCustomer(getActivity()).deleteCustomer(mCustomer);
				Toast.makeText(getActivity(), R.string.customer_del_bttn_toast,
							Toast.LENGTH_SHORT).show();
				getActivity().finish();
			}
		});

		return v;
	}
}