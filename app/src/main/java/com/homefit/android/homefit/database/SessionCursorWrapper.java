package com.homefit.android.homefit.database;

import java.util.UUID;
import android.database.Cursor;
import android.database.CursorWrapper;
import com.homefit.android.homefit.Session;
import com.homefit.android.homefit.database.HomeFitDbSchema.SessionTable;

public class SessionCursorWrapper extends CursorWrapper {
	public SessionCursorWrapper(Cursor cursor) {
		super(cursor);
	}

	public Session getSession() {
		String sessUuidString = getString(getColumnIndex(SessionTable.Cols.UUID));
		String custUuidString = getString(getColumnIndex(SessionTable.Cols.CUSTOMER_ID));
		String date = getString(getColumnIndex(SessionTable.Cols.DATE));
		String plan = getString(getColumnIndex(SessionTable.Cols.SESSION_PLAN));
		float cost = getFloat(getColumnIndex(SessionTable.Cols.COST));
		int isComplete = getInt(getColumnIndex(SessionTable.Cols.IS_COMPLETE));
		int isPaid = getInt(getColumnIndex(SessionTable.Cols.IS_PAID));

		Session session = new Session(UUID.fromString(sessUuidString));
		session.setCustId(custUuidString); //change to UUID
		session.setDate(date); //change to date
		session.setPlan(plan);
		session.setCost(cost);
		session.setComplete(isComplete != 0);
		session.setPaid(isPaid != 0);

		return session;
	}
}
