package com.goyalgadgets.vistaslate;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class StartupActivity extends Activity {

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.start);

		Spinner languagesSpinner = (Spinner) findViewById(R.id.languages_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		languagesSpinner.setAdapter(adapter);

		TextView enterNameText = (TextView) findViewById(R.id.enter_name);
		enterNameText.setTypeface(Typeface.createFromAsset(getAssets(), "Asap-Regular.otf"));

		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(StartupActivity.this, MainMenuActivity.class);
				startActivity(intent);
			}

		});
	}
}
