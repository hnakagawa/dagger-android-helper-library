package com.anprosit.android.dagger.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/27.
 */
public abstract class DaggerService extends Service implements DaggerContext {
	private DaggerHelper mHelper = new DaggerHelper();

	@Override
	public void onCreate() {
		super.onCreate();
		mHelper.onCreate(this, getModules());
	}

	@Override
	public void onDestroy() {
		mHelper.onDestroy();
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	protected abstract List<Object> getModules();

	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}
