package com.anprosit.android.dagger.ui.v4;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author KeithYokoma
 */
public class DaggerListFragment extends ListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		((DaggerContext) getActivity()).inject(this);
	}
}
