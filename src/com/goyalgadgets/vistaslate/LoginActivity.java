package com.goyalgadgets.vistaslate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.login);

		TextView slogan = (TextView) findViewById(R.id.slogan);
		slogan.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		TextView queue = (TextView) findViewById(R.id.queue);
		queue.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		Button login = (Button) findViewById(R.id.login);
		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, ServicesActivity.class));
			}

		});

		Button newaccount = (Button) findViewById(R.id.newaccount);
		newaccount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, NewAccountActivity.class));
			}

		});
	}
}
