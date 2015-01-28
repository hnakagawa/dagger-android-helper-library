package com.anprosit.android.dagger.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebViewFragment;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author KeithYokoma
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DaggerWebViewFragment extends WebViewFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
