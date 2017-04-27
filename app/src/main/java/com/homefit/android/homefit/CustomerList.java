package com.homefit.android.homefit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.homefit.android.homefit.database.CustomerCursorWrapper;
import com.homefit.android.homefit.database.HomeFitBaseHelper;
import com.homefit.android.homefit.database.HomeFitDbSchema.CustomerTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CustomerList {
	private static CustomerList sCustomerList;

	private Context mContext;
	private SQLiteDatabase mDatabase;

	public static CustomerList getCustomer(Context context) {
		if (sCustomerList ==  null) {
			sCustomerList = new CustomerList(context);
		}
		return sCustomerList;
	}

	private CustomerList(Context context) {
		mContext = context.getApplicationContext();
		mDatabase = new HomeFitBaseHelper(context)
			.getWritableDatabase();
	}

	private static ContentValues getContentValues(Customer customer) {
		ContentValues values = new ContentValues();
		values.put(CustomerTable.Cols.UUID, customer.getId().toString());
		values.put(CustomerTable.Cols.NAME, customer.getName());
		values.put(CustomerTable.Cols.ADDRESS_ONE, customer.getAddrOne());
		values.put(CustomerTable.Cols.ADDRESS_TWO, customer.getAddrTwo());
		values.put(CustomerTable.Cols.CITY, customer.getCity());
		values.put(CustomerTable.Cols.STATE, customer.getState());
		values.put(CustomerTable.Cols.ZIP, customer.getZip());
		values.put(CustomerTable.Cols.PHONE, customer.getPhone());
		return values;
	}

	public void addCustomer(Customer c) {
		ContentValues values = getContentValues(c);
		mDatabase.insert(CustomerTable.TABLE_NAME, null, values);
	}

	public void updateCustomer(Customer customer) {
		String uuidString = customer.getId().toString();
		ContentValues values = getContentValues(customer);

		mDatabase.update(CustomerTable.TABLE_NAME, values,
			CustomerTable.Cols.UUID + " = ?",
			new String[] { uuidString });
	}

	private CursorWrapper queryCustomers(String whereClause, String[] whereArgs) {
		Cursor cursor = mDatabase.query(
			CustomerTable.TABLE_NAME,
			null, // Columns - null selects all columns
			whereClause,
			whereArgs,
			null, // groupBy
			null, // having
			null  // orderBy
		);
		return new CustomerCursorWrapper(cursor);
	}

	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<>();

		CustomerCursorWrapper cursor = (CustomerCursorWrapper) queryCustomers(null, null);

		try {
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				customers.add(cursor.getCustomer());
				cursor.moveToNext();
			}
		} finally {
			cursor.close();
		}

		return customers;
	}

	public Customer getCustomer(UUID id) {
		CustomerCursorWrapper cursor = (CustomerCursorWrapper) queryCustomers(
			CustomerTable.Cols.UUID + " = ?",
			new String[] { id.toString() }
		);

		try {
			if (cursor.getCount() == 0) {
				return  null;
			}
			cursor.moveToFirst();
			return cursor.getCustomer();
		}
		finally {
			cursor.close();
		}
	}
}