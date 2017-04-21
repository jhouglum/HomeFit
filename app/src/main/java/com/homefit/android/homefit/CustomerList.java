package com.homefit.android.homefit;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerList {

	private static CustomerList sCustomerList;

	private List<Customer> mCustomers;

	public static CustomerList get(Context context) {
		if (sCustomerList ==  null) {
			sCustomerList = new CustomerList(context);
		}
		return sCustomerList;
	}

	private CustomerList(Context context) {
		mCustomers = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Customer customer = new Customer();
			customer.setCustomerFullName("Customer Fullname " + i);
			customer.setCustomerAddressLine1(i + " Customer address line 1 drive");
			customer.setCustomerAddressLine2("Apt# " + i);
			customer.setCustomerCity("City" + i);
			customer.setCustomerState("State" + i);
			customer.setCustomerPostalCode("Zip" + i);
			customer.setCustomerPhone("Phone" + i);
		}
	}

	public List<Customer> getCustomers() {
		return mCustomers;
	}

	public Customer get(UUID id) {
		for (Customer customer : mCustomers) {
			if (customer.getCustomerId().equals(id)) {
				return customer;
			}
		}
		return null;
	}

}
