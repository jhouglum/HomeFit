package com.homefit.android.homefit.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import com.homefit.android.homefit.Customer;
import com.homefit.android.homefit.database.HomeFitDbSchema.CustomerTable;

import java.util.UUID;

public class CustomerCursorWrapper extends CursorWrapper {
	public CustomerCursorWrapper(Cursor cursor) {
		super(cursor);
	}

	public Customer getCustomer() {
		String uuidString = getString(getColumnIndex(CustomerTable.Cols.UUID));
		String name = getString(getColumnIndex(CustomerTable.Cols.NAME));
		String addressOne = getString(getColumnIndex(CustomerTable.Cols.ADDRESS_ONE));
		String addressTwo = getString(getColumnIndex(CustomerTable.Cols.ADDRESS_TWO));
		String city = getString(getColumnIndex(CustomerTable.Cols.CITY));
		String state = getString(getColumnIndex(CustomerTable.Cols.STATE));
		String zip = getString(getColumnIndex(CustomerTable.Cols.ZIP));
		String phone = getString(getColumnIndex(CustomerTable.Cols.PHONE));

		Customer customer = new Customer(UUID.fromString(uuidString));
		customer.setName(name);
		customer.setAddrOne(addressOne);
		customer.setAddrTwo(addressTwo);
		customer.setCity(city);
		customer.setState(state);
		customer.setZip(zip);
		customer.setPhone(phone);

		return customer;
	}
}
