package com.homefit.android.homefit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class CustomerActivity extends SingleFragmentActivity {

	private static final String EXTRA_CUSTOMER_ID =
		"com.homefit.android.homefit.customer_id";

	public static Intent newIntent(Context packageContext, UUID customerId) {
		Intent intent = new Intent(packageContext, CustomerActivity.class);
		intent.putExtra(EXTRA_CUSTOMER_ID, customerId);
		return intent;
	}

	protected Fragment createFragment() {
		UUID customerId = (UUID) getIntent()
				.getSerializableExtra(EXTRA_CUSTOMER_ID);
		return CustomerFragment.newInstance(customerId);
	}
}
