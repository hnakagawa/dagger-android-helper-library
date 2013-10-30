package com.anprosit.android.dagger.ui;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by hnakagawa on 13/09/18.
 */
public class DaggerDialogFragment extends DialogFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((DaggerFragmentActivity) getActivity()).inject(this);
    }
}
