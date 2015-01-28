package com.anprosit.android.dagger.ui.v4;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author hnakagawa
 */
public class DaggerFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
