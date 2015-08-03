package com.anprosit.android.dagger.application;

import android.app.Application;
import android.content.Context;

import com.anprosit.android.dagger.DaggerContext;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
public abstract class DaggerApplication extends Application implements DaggerContext {
	private ObjectGraph mApplicationGraph;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);

		mApplicationGraph = ObjectGraph.create(getModules().toArray());
		mApplicationGraph.inject(this);
	}

	protected abstract List<Object> getModules();

	@Override
	public ObjectGraph getObjectGraph() {
		return mApplicationGraph;
	}

	@Override
	public <T> T inject(T obj) {
		return mApplicationGraph.inject(obj);
	}
}
