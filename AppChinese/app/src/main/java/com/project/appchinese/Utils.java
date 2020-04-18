package com.project.appchinese;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;

public class Utils
{
	public static final int GOOGLE_SIGNIN = 0;
	public static final String TAG = "ChineseApp";

	public static void hideSoftKeyboard(Activity activity) {
		InputMethodManager inputMethodManager =
				(InputMethodManager) activity.getSystemService(
						Activity.INPUT_METHOD_SERVICE);
		inputMethodManager.hideSoftInputFromWindow(
				activity.getCurrentFocus().getWindowToken(), 0);
	}
}
