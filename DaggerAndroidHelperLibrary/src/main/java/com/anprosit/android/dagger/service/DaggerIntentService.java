package com.anprosit.android.dagger.service;

import android.app.IntentService;
import android.content.Intent;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author KeithYokoma
 */
public abstract class DaggerIntentService extends IntentService implements DaggerContext {
	private DaggerHelper mHelper = new DaggerHelper();

	public DaggerIntentService(String name) {
		super(name);
	}

	@Override
	public void onCreate() {
		mHelper.onCreate(this, getModules());
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mHelper.onDestroy();
	}

	@Override
	protected abstract void onHandleIntent(Intent intent);

	protected abstract List<Object> getModules();

	@Override
	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}
