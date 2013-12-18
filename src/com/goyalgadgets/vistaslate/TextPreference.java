package com.goyalgadgets.vistaslate;

import android.content.Context;
import android.preference.DialogPreference;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

public class TextPreference extends EditTextPreference {

	public TextPreference(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onDialogClosed(boolean positiveResult) {
		super.onDialogClosed(positiveResult);
		if (positiveResult) {
			super.setSummary(getText());
			notifyChanged();
		}
	}

}