package com.homefit.android.homefit;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class BillListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new BillListFragment();
	}
}
