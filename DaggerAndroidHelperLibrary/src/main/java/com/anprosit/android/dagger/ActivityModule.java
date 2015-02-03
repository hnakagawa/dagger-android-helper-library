package com.anprosit.android.dagger;

import android.app.Activity;
import android.content.Context;

import com.anprosit.android.dagger.annotation.ForActivity;

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
	@ForActivity
	ObjectGraph provideActivityGraph() {
		DaggerContext context = (DaggerContext) mActivity;
		return context.getObjectGraph();
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
