package com.anprosit.android.dagger.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import com.anprosit.android.dagger.DaggerContext;
import com.google.android.gms.maps.MapFragment;

/**
 * @author KeithYokoma
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DaggerMapFragment extends MapFragment {
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
