package com.homefit.android.homefit;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SessionBook {

	private static SessionBook mSessionBook;
	private List<Session> mSessions;

	public static SessionBook get(Context context) {
		if (mSessionBook == null) {
			mSessionBook = new SessionBook(context);
		}
		return mSessionBook;
	}

	private SessionBook(Context context) {
		mSessions = new ArrayList<>();
	}

	public List<Session> getSessions() {
		return mSessions;
	}

	public Session getSession(UUID id) {
		for (Session session : mSessions) {
			if (session.getSessionId().equals(id)) {
				return session;
			}
		}
		return null;
	}
}
