package com.homefit.android.homefit;

import java.util.Date;
import java.util.UUID;
import com.homefit.android.homefit.Bill;

public class Session {

	private UUID mSessionId;
	private UUID mCustomerId;
	private Date mSessionDate;
	private String mSessionPlan;
	private float mSessionCost;
	private boolean mSessionIsComplete;
	private boolean mSessionIsPaid;
	private Bill mSessionBill;

	public Session(UUID customerId, Date sessionDate, String sessionPlan,
			float sessionCost, boolean sessionIsPaid) {
		mSessionId = UUID.randomUUID();
		mCustomerId = customerId;
		mSessionPlan = sessionPlan;
		mSessionDate = sessionDate;
		mSessionCost = sessionCost;
		mSessionIsPaid = sessionIsPaid;
		mSessionBill = new Bill(mSessionId, mSessionCost, mSessionIsPaid);
	}

	public UUID getSessionId() {
		return mSessionId;
	}

	public UUID getCustomerId() {
		return mCustomerId;
	}

	public Date getSessionDate() {
		return mSessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		mSessionDate = sessionDate;
	}

	public float getSessionCost() {
		return mSessionCost;
	}

	public void setSessionCost(float sessionCost) {
		mSessionCost = sessionCost;
	}

	public boolean isSessionComplete() {
		return mSessionIsComplete;
	}

	public void setSessionComplete(boolean sessionComplete) {
		mSessionIsComplete = sessionComplete;
	}

	public boolean isSessionPaid() {
		return mSessionIsPaid;
	}

	public void setSessionPaid(boolean sessionPaid) {
		mSessionIsPaid = sessionPaid;
	}
}
