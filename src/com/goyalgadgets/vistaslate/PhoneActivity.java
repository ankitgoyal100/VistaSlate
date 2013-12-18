package com.goyalgadgets.vistaslate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class PhoneActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.phone);

		Button done = (Button) findViewById(R.id.enter);
		done.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Toast.makeText(PhoneActivity.this, "Great! We will send you a text message when it is your turn", Toast.LENGTH_LONG).show();
				startActivity(new Intent(PhoneActivity.this, StartupActivity.class));
			}

		});
	}
}
