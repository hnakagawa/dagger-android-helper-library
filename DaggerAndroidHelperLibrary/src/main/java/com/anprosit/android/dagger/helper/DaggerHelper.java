package com.anprosit.android.dagger.helper;

import android.content.Context;

import com.anprosit.android.dagger.application.DaggerApplication;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/27.
 */
public class DaggerHelper {
	private ObjectGraph mObjectGraph;

	public void onCreate(Context context, List<Object> modules) {
		DaggerApplication application = (DaggerApplication) context.getApplicationContext();
		mObjectGraph = application.getObjectGraph().plus(modules.toArray());

		// Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
		mObjectGraph.inject(context);
	}

	public void onDestroy() {
		// Eagerly clear the reference to the activity graph to allow it to be garbage collected as
		// soon as possible.
		mObjectGraph = null;
	}

	public <T> T inject(T obj) {
		return mObjectGraph.inject(obj);
	}

	public ObjectGraph getObjectGraph() {
		return mObjectGraph;
	}
}
