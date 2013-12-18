package com.goyalgadgets.vistaslate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class NewAccountActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
	private Context context = this;
	private Button btn;
	private SharedPreferences prefs;
	private com.goyalgadgets.vistaslate.DatePreference datePref;
	private EditTextPreference editTextPref;
	private Handler handler;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.make_trip);
		setContentView(R.layout.main_make);
		handler = new Handler();
		PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);

		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(this);
		Editor editor = prefs.edit();
		editor.clear();
		editor.commit();
		System.out.println("here we are");
		onContentChanged();

		datePref = (com.goyalgadgets.vistaslate.DatePreference) findPreference("dob");
		editTextPref = (EditTextPreference) findPreference("prefName");
		editTextPref.setText("");

		btn = (Button) findViewById(R.id.doneButton);
		btn.setBackground(getResources().getDrawable(R.drawable.login_button_background));
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Thanks for your entry! Our associate will be glad to finish creating your account.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(NewAccountActivity.this, ESPNActivity.class);
				startActivity(intent);
			}

		});

	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		// Preference pref = findPreference(key);
		// if (pref instanceof EditTextPreference) {
		// EditTextPreference etp = (EditTextPreference) pref;
		// if (!etp.getText().equals(""))
		// pref.setSummary(etp.getText());
		// }
	}
}
