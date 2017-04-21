package com.homefit.android.homefit;

import java.util.Date;
import java.util.UUID;

public class Bill {

	private UUID mBillId;
	private float mBillAmount;
	private boolean mBillIsPaid;
	private Date mPaymentDate;
	private boolean mIsBillable;

	public Bill(UUID billId, float billAmount, boolean billIsPaid) {
		mBillId = billId;
		mBillAmount = billAmount;
		mBillIsPaid = billIsPaid;
	}

	public UUID getBillId() {
		return mBillId;
	}

	public float getBillAmount() {
		return mBillAmount;
	}

	public void setBillAmount(float billAmount) {
		mBillAmount = billAmount;
	}

	public boolean getBillIsPaid() {
		return mBillIsPaid;
	}

	public boolean isBillable() {
		return mIsBillable;
	}

	public void setBillable(boolean isBillable) {
		mIsBillable = isBillable;
	}

	public void setBillIsPaid(boolean billIsPaid) {
		mBillIsPaid = billIsPaid;
	}

	public Date getPaymentDate() {
		return mPaymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		mPaymentDate = paymentDate;
	}
}
