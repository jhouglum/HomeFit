package com.homefit.android.homefit;

import android.content.Context;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.homefit.android.homefit.database.SessionCursorWrapper;
import com.homefit.android.homefit.database.HomeFitBaseOpenHelper;
import com.homefit.android.homefit.database.HomeFitDbSchema.SessionTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SessionList {
	private static SessionList sSessionList;

	private Context mContext;
	private SQLiteDatabase mDatabase;

	public static SessionList get(Context context) {
		if (sSessionList == null) {
			sSessionList = new SessionList(context);
		}
		return sSessionList;
	}

	private SessionList(Context context) {
		mContext = context.getApplicationContext();
		mDatabase = new HomeFitBaseOpenHelper(mContext)
					.getWritableDatabase();
	}

	private static ContentValues getContentValues(Session session) {
		ContentValues values = new ContentValues();
		values.put(SessionTable.Cols.UUID, session.getSessId().toString());
		values.put(SessionTable.Cols.CUSTOMER_ID, session.getCustId()); //change to UUID
		values.put(SessionTable.Cols.DATE, session.getDate()); //change to date
		values.put(SessionTable.Cols.SESSION_PLAN, session.getPlan());
		values.put(SessionTable.Cols.IS_COMPLETE, session.isComplete() ? 1 : 0);
		values.put(SessionTable.Cols.SESSION_PLAN, session.isPaid() ? 1 : 0);
		return values;
	}

	public void addSession(Session s) {
		ContentValues values = getContentValues(s);
		mDatabase.insert(SessionTable.TABLE_NAME, null, values);
	}

	public void updateSession(Session session) {
		String uuidString = session.getSessId().toString();
		ContentValues values = getContentValues(session);

		mDatabase.update(SessionTable.TABLE_NAME, values,
			SessionTable.Cols.UUID + " = ?",
			new String[] { uuidString });
	}

	private SessionCursorWrapper querySessions(String whereClause,
																						 String[] whereArgs) {
		Cursor cursor = mDatabase.query(
			SessionTable.TABLE_NAME,
			null, // Columns - null selects all columns
			whereClause,
			whereArgs,
			null, // groupBy
			null, // having
			null  // orderBy
		);

		return new SessionCursorWrapper(cursor);
	}

	public List<Session> getSessions() {
		List<Session> sessions = new ArrayList<>();

		SessionCursorWrapper cursor = querySessions(null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			sessions.add(cursor.getSession());
			cursor.moveToNext();
		}
		cursor.close();

		return sessions;
	}

	public Session getSessions(UUID id) {
		SessionCursorWrapper cursor = querySessions(
			SessionTable.Cols.UUID + " = ?",
			new String[] { id.toString() }
		);

		try {
			if (cursor.getCount() == 0) {
				return null;
			}

			cursor.moveToFirst();
			return cursor.getSession();
		} finally {
			cursor.close();
		}
	}
}