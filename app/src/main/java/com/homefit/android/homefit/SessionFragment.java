package com.homefit.android.homefit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class SessionFragment extends Fragment {

	private static final String ARG_SESSION_ID = "session_id";

	private Session mSession;
	private TextView mCustIdTV;
	private Button mDateButton;
	private EditText mPlanEdTxt;
	private EditText mCostEdTxt;
	private CheckBox mCompleteChkBox;
	private CheckBox mIsPaidChkBox;

	public static SessionFragment newInstance(UUID sessionId) {
		Bundle args = new Bundle();
		args.putSerializable(ARG_SESSION_ID, sessionId);

		SessionFragment fragment = new SessionFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID sessionId = (UUID) getArguments().getSerializable(ARG_SESSION_ID);
		mSession = SessionList.get(getActivity()).getSessions(sessionId);
		setHasOptionsMenu(true);
	}

	@Override
	public void onPause() {
		super.onPause();

		SessionList.get(getActivity())
			.updateSession(mSession);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_session, container, false);

		mCustIdTV = (TextView) v.findViewById(R.id.session_frag_cust_name_tv);
		mCustIdTV.setText(mSession.getPlan());
		mCustIdTV.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				//Needs to be changed to a UUID at some point when I figure out how
				//the user will select a customer.
				//mSession.setSessId(UUID.fromString(String.valueOf(s)));
				mSession.setPlan(s.toString());
			}
			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		mDateButton = (Button) v.findViewById(R.id.session_frag_sess_date);
		mDateButton.setText(R.string.session_date_picker_title);
//		updateDate(); not now
		mDateButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(),"I will be date picker", Toast.LENGTH_SHORT);
			}
		});

		mPlanEdTxt = (EditText) v.findViewById(R.id.session_frag_sess_plan);
		mPlanEdTxt.setHint(R.string.session_plan);

		mCostEdTxt = (EditText) v.findViewById(R.id.session_frag_sess_cost);
		mCostEdTxt.setHint(R.string.session_cost);

		mCompleteChkBox = (CheckBox) v.findViewById(R.id.session_frag_sess_complete_chkbox);
		mCompleteChkBox.setChecked(mSession.isComplete());
		mCompleteChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSession.setComplete(isChecked);
			}
		});

		mIsPaidChkBox = (CheckBox) v.findViewById(R.id.session_frag_sess_paid_chkbox);
		mIsPaidChkBox.setChecked(mSession.isPaid());
		mIsPaidChkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSession.setPaid(isChecked);
			}
		});

		return v;
	}
}
