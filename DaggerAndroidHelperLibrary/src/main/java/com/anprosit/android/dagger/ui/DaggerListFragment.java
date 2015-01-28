package com.anprosit.android.dagger.ui;

import android.annotation.TargetApi;
import android.app.ListFragment;
import android.os.Build;
import android.os.Bundle;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author KeithYokoma
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DaggerListFragment extends ListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
