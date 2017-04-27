package com.homefit.android.homefit;

import java.util.Date;
import java.util.UUID;

public class Session {

	private UUID mSessId;
	private String mCustId; //change to UUID
	private String mDate; //change to date
	private String mPlan;
	private float mCost;
	private boolean mComplete;
	private boolean mIsPaid;

	public Session() {
		this(UUID.randomUUID());
	}

	public Session(UUID id) {
		mSessId = id;
	}

	public UUID getSessId() {
		return mSessId;
	}

	public void setSessId(UUID sessId) {
		mSessId = sessId;
	}

	public String getCustId() {
		return mCustId;
	}

	public void setCustId(String custId) {
		mCustId = custId;
	}

	public String getDate() { //change to date
		return mDate;
	}

	public void setDate(String date) { //change to date
		mDate = date;
	}

	public String getPlan() {
		return mPlan;
	}

	public void setPlan(String plan) {
		mPlan = plan;
	}

	public float getCost() {
		return mCost;
	}

	public void setCost(float cost) {
		mCost = cost;
	}

	public boolean isComplete() {
		return mComplete;
	}

	public void setComplete(boolean complete) {
		mComplete = complete;
	}

	public boolean isPaid() {
		return mIsPaid;
	}

	public void setPaid(boolean paid) {
		mIsPaid = paid;
	}
}