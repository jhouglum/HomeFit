package com.homefit.android.homefit;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerList {

	private static CustomerList sCustomerList;

	private ArrayList<Customer> mCustomers;

	public static CustomerList getCustomer(Context context) {
		if (sCustomerList ==  null) {
			sCustomerList = new CustomerList(context);
		}
		return sCustomerList;
	}

	private CustomerList(Context context) {
		mCustomers = new ArrayList<>();
	}

	public void addCustomer(Customer c) {
		mCustomers.add(c);
	}

	public List<Customer> getCustomers() {
		return mCustomers;
	}

	public Customer getCustomer(UUID id) {
		for (Customer customer : mCustomers) {
			if (customer.getId().equals(id)) {
				return customer;
			}
		}
		return null;
	}

}
