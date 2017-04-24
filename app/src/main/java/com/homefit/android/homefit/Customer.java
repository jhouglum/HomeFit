package com.homefit.android.homefit;

import java.util.UUID;

public class Customer {

	private UUID mId;
	private String mName;
	private String mAddrOne;
	private String mAddrTwo;
	private String mCity;
	private String mState;
	private String mZip;
	private String mPhone;

	public Customer(String addrOne, String name,
									String addrTwo, String city, String state,
									String zip, String phone) {

		mId = UUID.randomUUID();
		mName = name;
		mAddrOne = addrOne;
		mAddrTwo = addrTwo;
		mCity = city;
		mState = state;
		mZip = zip;
		mPhone = phone;
	}

	public Customer() {
		mId = UUID.randomUUID();
	}

	public UUID getId() {
		return mId;
	}

	public String getName() {
		return mName;
	}

	public void setName(String name) {
		mName = name;
	}

	public String getAddrOne() {
		return mAddrOne;
	}

	public void setAddrOne(String addrOne) {
		mAddrOne = addrOne;
	}

	public String getAddrTwo() {
		return mAddrTwo;
	}

	public void setAddrTwo(String addrTwo) {
		mAddrTwo = addrTwo;
	}

	public String getCity() {
		return mCity;
	}

	public void setCity(String city) {
		mCity = city;
	}

	public String getState() {
		return mState;
	}

	public void setState(String state) {
		mState = state;
	}

	public String getZip() {
		return mZip;
	}

	public void setZip(String zip) {
		mZip = zip;
	}

	public String getPhone() {
		return mPhone;
	}

	public void setPhone(String phone) {
		mPhone = phone;
	}
}
