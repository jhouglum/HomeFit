package com.homefit.android.homefit;

import android.location.Address;

import java.util.UUID;

public class Customer {

	private UUID mCustomerId;
	private String mCustomerFullName;
	private String mCustomerAddressLine1;
	private String mCustomerAddressLine2;
	private String mCustomerCity;
	private String mCustomerState;
	private String mCustomerPostalCode;
	private String mCustomerPhone;

	public Customer(String customerAddressLine1, String customerFullName,
			String customerAddressLine2, String customerCity, String customerState,
			String customerPostalCode, String customerPhone) {

		mCustomerId = UUID.randomUUID();
		mCustomerFullName = customerFullName;
		mCustomerAddressLine1 = customerAddressLine1;
		mCustomerAddressLine2 = customerAddressLine2;
		mCustomerCity = customerCity;
		mCustomerState = customerState;
		mCustomerPostalCode = customerPostalCode;
		mCustomerPhone = customerPhone;
	}

	public Customer() {
		mCustomerId = UUID.randomUUID();
	}

	public UUID getCustomerId() {
		return mCustomerId;
	}

	public String getCustomerFullName() {
		return mCustomerFullName;
	}

	public void setCustomerFullName(String customerFullName) {
		mCustomerFullName = customerFullName;
	}

	public String getCustomerAddressLine1() {
		return mCustomerAddressLine1;
	}

	public void setCustomerAddressLine1(String customerAddressLine1) {
		mCustomerAddressLine1 = customerAddressLine1;
	}

	public String getCustomerAddressLine2() {
		return mCustomerAddressLine2;
	}

	public void setCustomerAddressLine2(String customerAddressLine2) {
		mCustomerAddressLine2 = customerAddressLine2;
	}

	public String getCustomerCity() {
		return mCustomerCity;
	}

	public void setCustomerCity(String customerCity) {
		mCustomerCity = customerCity;
	}

	public String getCustomerState() {
		return mCustomerState;
	}

	public void setCustomerState(String customerState) {
		mCustomerState = customerState;
	}

	public String getCustomerPostalCode() {
		return mCustomerPostalCode;
	}

	public void setCustomerPostalCode(String customerPostalCode) {
		mCustomerPostalCode = customerPostalCode;
	}

	public String getCustomerPhone() {
		return mCustomerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		mCustomerPhone = customerPhone;
	}
}
