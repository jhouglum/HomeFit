package com.homefit.android.homefit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomerListFragment extends Fragment {

	private RecyclerView mCustomerRecyclerView;
	private CustomerAdapter mCustomerAdapter;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_customer_list, container, false);

		mCustomerRecyclerView = (RecyclerView) view.findViewById(R.id.customer_recycler_view);
		mCustomerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		updateUI();

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
		inflater.inflate(R.menu.customer_menu, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_new_customer:
				Customer customer = new Customer();
				CustomerList.getCustomer(getActivity()).addCustomer(customer);
				Intent intentNew = CustomerActivity.newIntent(getActivity(),
					customer.getId());
				startActivity(intentNew);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void updateUI() {
		CustomerList customerList = CustomerList.getCustomer(getActivity());
		List<Customer> customers = customerList.getCustomers();

		if (mCustomerAdapter == null) {
			mCustomerAdapter = new CustomerAdapter(customers);
			mCustomerRecyclerView.setAdapter(mCustomerAdapter);
		} else {
			mCustomerAdapter.notifyDataSetChanged();
		}
	}

	private class CustomerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private TextView mNameTextView;

		private Customer mCustomer;

		public CustomerHolder(View itemView) {
			super(itemView);
			itemView.setOnClickListener(this);

			mNameTextView = (TextView) itemView.findViewById(R.id.list_item_customer_name_text_view);

		}

		public void bindCustomer(Customer customer) {
			mCustomer = customer;
			mNameTextView.setText(mCustomer.getName());
		}

		@Override
		public void onClick(View v) {
			Intent intent = CustomerActivity.newIntent(getActivity(), mCustomer.getId());
			startActivity(intent);
		}
	}

	private class CustomerAdapter extends RecyclerView.Adapter<CustomerHolder> {

		private List<Customer> mCustomers;

		public CustomerAdapter(List<Customer> customers) {
			mCustomers = customers;
		}

		@Override
		public CustomerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			View view = layoutInflater.inflate(R.layout.list_item_customer,
				parent, false);
			return new CustomerHolder(view);
		}

		@Override
		public void onBindViewHolder(CustomerHolder holder, int position) {
			Customer customer = mCustomers.get(position);
			holder.bindCustomer(customer);
		}

		@Override
		public int getItemCount() {
			return mCustomers.size();
		}
	}
}