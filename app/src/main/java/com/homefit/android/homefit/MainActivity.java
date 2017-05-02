package com.homefit.android.homefit;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private static final String EXTRA_CUSTOMER_ID =
				"com.homefit.android.homefit.customer_id";
	private static final String EXTRA_SESSION_ID =
				"com.homefit.android.homefit.session_id";

	private TabLayout mTabLayout;
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(
					R.id.main_act_tool_bar);
		toolbar.inflateMenu(R.menu.menu_main);
		setSupportActionBar(toolbar);

		mViewPager = (ViewPager) findViewById(
					R.id.main_act_view_container);
		createViewPager(mViewPager);

		mTabLayout = (TabLayout) findViewById(
					R.id.main_act_tabs);
		mTabLayout.setupWithViewPager(mViewPager);
		createTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_logoff:
				Toast.makeText(this, R.string.msg_logging_off, Toast.LENGTH_SHORT).show();
				if (LoginActivity.class == null) {
					Intent intentLogin = new Intent(this, LoginActivity.class);
					startActivity(intentLogin);
				}
				this.finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void createTabs() {
		TextView mCustTab = (TextView) LayoutInflater.from(this)
				.inflate(R.layout.tab_icon_custom, null);
		mCustTab.setText(R.string.tab_title_customer);
		mCustTab.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
		mCustTab.setSelected(true);
		mTabLayout.getTabAt(0).setCustomView(mCustTab);

		TextView mSessTab = (TextView) LayoutInflater.from(this)
				.inflate(R.layout.tab_icon_custom, null);
		mSessTab.setText(R.string.tab_title_sessions);
		mSessTab.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
		mTabLayout.getTabAt(1).setCustomView(mSessTab);

		TextView mBillTab = (TextView) LayoutInflater.from(this)
				.inflate(R.layout.tab_icon_custom, null);
		mBillTab.setText(R.string.tab_title_billing);
		mBillTab.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
		mTabLayout.getTabAt(2).setCustomView(mBillTab);
	}

	private void createViewPager(ViewPager viewPager) {
		ViewPagerAdapter adapter = new ViewPagerAdapter(
					getSupportFragmentManager());
		adapter.addFrag(new CustomerListFragment(),
					getString(R.string.lbl_screen_customer));
		adapter.addFrag(new SessionListFragment(),
					getString(R.string.lbl_screen_sessions));
		adapter.addFrag(new BillListFragment(),
					getString(R.string.lbl_screen_billing));
		viewPager.setAdapter(adapter);
		viewPager.setOffscreenPageLimit(adapter.getCount());
	}

	class ViewPagerAdapter extends FragmentPagerAdapter {
		private final List<Fragment> mFragList = new ArrayList<>();
		private final List<String> mFragTitleList = new ArrayList<>();

		public ViewPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragList.get(position);
		}

		@Override
		public int getCount() {
			return mFragList.size();
		}

		public void addFrag(Fragment fragment, String title) {
			mFragList.add(fragment);
			mFragTitleList.add(title);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragTitleList.get(position);
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		mViewPager.getChildCount();
	}

	@Override
	protected void onPostResume() {
		super.onPostResume();
	}
}
