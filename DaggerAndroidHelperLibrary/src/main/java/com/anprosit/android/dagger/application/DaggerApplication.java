package com.anprosit.android.dagger.application;

import android.app.Application;

import com.anprosit.android.dagger.DaggerContext;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
public abstract class DaggerApplication extends Application implements DaggerContext {
	private ObjectGraph mApplicationGraph;

	@Override
	public void onCreate() {
		super.onCreate();
		mApplicationGraph = ObjectGraph.create(getModules().toArray());
		mApplicationGraph.inject(this);
	}

	protected abstract List<Object> getModules();

	@Override
	public ObjectGraph getObjectGraph() {
		return mApplicationGraph;
	}
}
