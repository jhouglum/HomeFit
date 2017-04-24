package com.homefit.android.homefit;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

	private ImageView mImageView;
	private EditText mEdTxtLogin;
	private EditText mEdTxtPass;
	private Button mBttnLogin;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mImageView = (ImageView) findViewById(R.id.login_image_view);
		mEdTxtLogin = (EditText) findViewById(R.id.login_activity_login_tf);
		mEdTxtPass = (EditText) findViewById(R.id.login_activity_pass_tf);
		mBttnLogin = (Button) findViewById(R.id.login_activity_login_bttn);

  }

  public void onClick(View view) {

		String login = mEdTxtLogin.getText().toString();
		String pass = mEdTxtPass.getText().toString();

		if (login.equals(getString(R.string.user_str_user_name)) &&
				pass.equals(getString(R.string.user_str_password))) {
			Intent intent = new Intent(LoginActivity.this,
					CustomerListActivity.class);
			startActivity(intent);
		} else {
			clearPassword();
			Toast.makeText(this, R.string.msg_login_unsuccessful,
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		clearPassword();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	protected void clearPassword() {
		mEdTxtPass.setText("");
	}
}

