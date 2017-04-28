package com.homefit.android.homefit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class BillListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

//	private OnFragmentInteractionListener mListener;

	private RecyclerView mBillingRecyclerView;
	private BillingAdapter mBillingAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.temp_bill_list_view, container, false);
		ListView tempList = (ListView) view.findViewById(R.id.temp_billing_list_view); //replace
		ArrayAdapter tempArrayAdapter = ArrayAdapter.createFromResource(getActivity(), //replace
					R.array.temp_bill_list, android.R.layout.simple_list_item_1); //replace
		tempList.setAdapter(tempArrayAdapter); //replace
		tempList.setOnItemClickListener(this); //replace

//		mBillingRecyclerView = (RecyclerView) view.findViewById(R.id.billing_recycler_view);
//		mBillingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//		updateUI();

		return view;
	}



	@Override
	public void onResume() {
		super.onResume();
		updateUI();
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.billing_menu, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_billing:
				Toast.makeText(getActivity(),"I'll do something in billing", Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void updateUI() {
//		BillListActivity billList = BillingList(getActivity().);
//		List<String> bills = getResources(R.array.temp_bill_list);

//		if (mBillingAdapter == null) {
//			mBillingAdapter = new BillingAdapter(sessions);
//			mSessionRecyclerView.setAdapter(mSessionsAdapter);
//		} else {
//			mSessionsAdapter.notifyDataSetChanged();
//		}
	}

	@Override
	public void onClick(View v) { //replace

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //replace

	}

	private class BillHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private TextView mBillTextView;

		private Bill mBill;

		public BillHolder(View itemView) {
			super(itemView);
			itemView.setOnClickListener(this);

			mBillTextView = (TextView) itemView.findViewById(R.id.list_item_billing_text_view);

		}

		public void bindBill(Bill bill) {
			mBill = bill;
			mBillTextView.setText(R.string.temp_bill_list_item_text); //replace
		}

		@Override
		public void onClick(View v) {
			Intent intent = BillActivity.newIntent(getActivity(), mBill.getBillId());
			startActivity(intent);
		}
	}

	private class BillingAdapter extends RecyclerView.Adapter<BillHolder> {

		private List<Bill> mBills;

		public BillingAdapter(List<Bill> bills) {
			mBills = bills;
		}

		@Override
		public BillHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			View view = layoutInflater.inflate(R.layout.list_item_billing,
				parent, false);
			return new BillHolder(view);
		}

		@Override
		public void onBindViewHolder(BillHolder holder, int position) {
			Bill bill = mBills.get(position);
			holder.bindBill(bill);
		}

		@Override
		public int getItemCount() {
			return mBills.size();
		}
	}
}
