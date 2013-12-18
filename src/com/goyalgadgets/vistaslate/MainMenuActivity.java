package com.goyalgadgets.vistaslate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends Activity {

	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.mainmenu);

		TextView slogan = (TextView) findViewById(R.id.slogan);
		slogan.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		TextView queue = (TextView) findViewById(R.id.queue);
		queue.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		TextView doyouwantto = (TextView) findViewById(R.id.doyouwant);
		doyouwantto.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		Button expedite = (Button) findViewById(R.id.expedite);
		expedite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainMenuActivity.this, LoginActivity.class));
			}

		});
		expedite.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		Button browse = (Button) findViewById(R.id.browse);
		browse.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainMenuActivity.this, NewsActivity.class));
			}

		});
		browse.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		Button wait = (Button) findViewById(R.id.wait);
		wait.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainMenuActivity.this, PhoneActivity.class));
			}

		});
		wait.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));
	}
}