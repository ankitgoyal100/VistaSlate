package com.goyalgadgets.vistaslate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class JoinTripActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
	private Context context = this;
	private Button btn;
	private SharedPreferences prefs;
	private EditTextPreference editTextPref;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.join_trip);
		setContentView(R.layout.main_join);
		PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);

		prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.registerOnSharedPreferenceChangeListener(this);
		Editor editor = prefs.edit();
		editor.clear();
		editor.commit();
		editTextPref = (EditTextPreference) findPreference("prefEndAddress");
		editTextPref.setText("");

		btn = (Button) findViewById(R.id.doneButton);
		btn.setBackground(getResources().getDrawable(R.drawable.login_button_background));
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "Thank you for your information. An Associate will be ready to meet you soonn.", Toast.LENGTH_LONG).show();
				Intent intent = new Intent(JoinTripActivity.this, NewsActivity.class);
				startActivity(intent);
			}

		});

	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		Preference pref = findPreference("prefEndAddress");
		if (pref instanceof EditTextPreference) {
			EditTextPreference etp = (EditTextPreference) pref;
			if (!etp.getText().equals(""))
				pref.setSummary(etp.getText());
		}
	}

}
