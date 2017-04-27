package com.homefit.android.homefit;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class BillActivity extends SingleFragmentActivity{

	private static final String EXTRA_BILL_ID =
		"com.homefit.android.homefit.bill_id";

	public static Intent newIntent(Context packageContext, UUID customerId) {
		Intent intent = new Intent(packageContext, CustomerActivity.class);
		intent.putExtra(EXTRA_BILL_ID, customerId);
		return intent;
	}

	protected Fragment createFragment() {
		UUID customerId = (UUID) getIntent()
			.getSerializableExtra(EXTRA_BILL_ID);
		return CustomerFragment.newInstance(customerId);
	}
}
