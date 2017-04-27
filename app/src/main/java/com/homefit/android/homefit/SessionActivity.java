package com.homefit.android.homefit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class SessionActivity extends SingleFragmentActivity {

	private static final String EXTRA_SESSION_ID =
		"com.homefit.android.homefit.session_id";



	public static Intent newIntent(Context packageContext, UUID sessionId) {
		Intent intent = new Intent(packageContext, SessionActivity.class);
		intent.putExtra(EXTRA_SESSION_ID, sessionId);
		return intent;
	}

	protected Fragment createFragment() {
		UUID sessionId = (UUID) getIntent()
			.getSerializableExtra(EXTRA_SESSION_ID);
		return SessionFragment.newInstance(sessionId);
	}
}
