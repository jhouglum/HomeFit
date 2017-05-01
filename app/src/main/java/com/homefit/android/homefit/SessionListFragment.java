package com.homefit.android.homefit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SessionListFragment extends Fragment {

	private RecyclerView mSessionRecyclerView;
	private SessionsAdapter mSessionsAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
													 Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_customer_list, container, false);

		mSessionRecyclerView = (RecyclerView) view.findViewById(R.id.customer_recycler_view);
		mSessionRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		updateUI();

		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
		updateUI();
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.sessions_list_menu, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.menu_item_new_session:
				Session session = new Session();
				SessionList.get(getActivity()).addSession(session);
				Intent intentNew = SessionActivity.newIntent(getActivity(),
					session.getSessId());
				startActivity(intentNew);
				return true;
			case R.id.menu_item_logoff:
				Toast.makeText(getActivity(), R.string.msg_logging_off, Toast.LENGTH_SHORT).show();
				if (LoginActivity.class == null) {
					Intent intentLogin = new Intent(getActivity(), LoginActivity.class);
					startActivity(intentLogin);
				}
				getActivity().finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	private void updateUI() {
		SessionList sessionList = SessionList.get(getActivity());
		List<Session> sessions = sessionList.getSessions();

		if (mSessionsAdapter == null) {
			mSessionsAdapter = new SessionsAdapter(sessions);
			mSessionRecyclerView.setAdapter(mSessionsAdapter);
		} else {
			mSessionsAdapter.notifyDataSetChanged();
		}
	}

	private class SessionHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private TextView mNameTextView;

		private Session mSession;

		public SessionHolder(View itemView) {
			super(itemView);
			itemView.setOnClickListener(this);

			mNameTextView = (TextView) itemView.findViewById(R.id.list_item_session_text_view);

		}

		public void bindSession(Session session) {
			mSession = session;
			mNameTextView.setText(R.string.session_cust_name); //replace
		}

		@Override
		public void onClick(View v) {
			Intent intent = SessionActivity.newIntent(getActivity(), mSession.getSessId());
			startActivity(intent);
		}
	}

	private class SessionsAdapter extends RecyclerView.Adapter<SessionHolder> {

		private List<Session> mSessions;

		public SessionsAdapter(List<Session> sessions) {
			mSessions = sessions;
		}

		@Override
		public SessionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
			View view = layoutInflater.inflate(R.layout.list_item_session,
				parent, false);
			return new SessionHolder(view);
		}

		@Override
		public void onBindViewHolder(SessionHolder holder, int position) {
			Session session = mSessions.get(position);
			holder.bindSession(session);
		}

		@Override
		public int getItemCount() {
			return mSessions.size();
		}
	}
}
