package com.anprosit.dagger.android;

import android.app.Activity;
import android.content.Context;

import com.anprosit.dagger.android.annotation.ForActivity;
import com.anprosit.dagger.android.ui.DaggerActivity;
import com.anprosit.dagger.android.ui.DaggerFragmentActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
@Module(
		complete = false,
		library = true
)
public class ActivityModule {
	private final Activity mActivity;

	public ActivityModule(Activity activity) {
		mActivity = activity;
	}

	@Provides
	@Singleton
	ObjectGraph provideActivityGraph() {
		if (mActivity instanceof DaggerFragmentActivity)
			return ((DaggerFragmentActivity) mActivity).getActivityGraph();
		return ((DaggerActivity) mActivity).getActivityGraph();
	}

	@Provides
	@Singleton
	@ForActivity
	Context provideActivityContext() {
		return mActivity;
	}

	@Provides
	@Singleton
	Activity provideActivity() {
		return mActivity;
	}
}