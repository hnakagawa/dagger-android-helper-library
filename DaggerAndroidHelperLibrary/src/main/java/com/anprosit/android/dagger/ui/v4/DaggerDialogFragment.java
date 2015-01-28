package com.anprosit.android.dagger.ui.v4;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.anprosit.android.dagger.DaggerContext;

/**
 * Created by hnakagawa on 13/09/18.
 */
public class DaggerDialogFragment extends DialogFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
