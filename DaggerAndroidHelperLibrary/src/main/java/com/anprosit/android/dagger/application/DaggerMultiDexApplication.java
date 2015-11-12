package com.anprosit.android.dagger.application;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.anprosit.android.dagger.DaggerContext;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author hnakagawa
 */
public abstract class DaggerMultiDexApplication extends MultiDexApplication implements DaggerContext {
	private ObjectGraph mApplicationGraph;

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);

		// Workaround for multidex
		new Runnable() {
			@Override
			public void run() {
				mApplicationGraph = ObjectGraph.create(getModules().toArray());
				mApplicationGraph.inject(DaggerMultiDexApplication.this);
			}
		}.run();
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
