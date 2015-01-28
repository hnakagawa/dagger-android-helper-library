package com.anprosit.android.dagger.ui.v4;

import android.os.Bundle;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author KeithYokoma
 */
public class DaggerPreferenceFragment extends PreferenceFragment {
	@Override
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		((DaggerContext) getActivity()).inject(this);
	}
}
