package com.anprosit.dagger.android.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
public class DaggerFragment extends Fragment {
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		((DaggerFragmentActivity) getActivity()).inject(this);
	}
}
