package com.anprosit.dagger.android.application;

import android.app.Application;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
public abstract class DaggerApplication extends Application {
	private ObjectGraph mApplicationGraph;

	@Override
	public void onCreate() {
		super.onCreate();
		mApplicationGraph = ObjectGraph.create(getModules().toArray());
		mApplicationGraph.inject(this);
	}

	protected abstract List<Object> getModules();

	public ObjectGraph getApplicationGraph() {
		return mApplicationGraph;
	}
}
