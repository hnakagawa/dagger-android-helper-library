package com.anprosit.android.dagger.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
public class DaggerFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerFragmentActivity) getActivity()).inject(this);
    }
}
