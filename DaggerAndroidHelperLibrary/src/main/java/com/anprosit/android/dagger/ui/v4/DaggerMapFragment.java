package com.anprosit.android.dagger.ui.v4;

import android.os.Bundle;

import com.anprosit.android.dagger.DaggerContext;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * @author hnakagawa
 */
public class DaggerMapFragment extends SupportMapFragment {
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
