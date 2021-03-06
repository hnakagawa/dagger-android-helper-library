package com.anprosit.android.dagger.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author hnakagawa
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DaggerFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
