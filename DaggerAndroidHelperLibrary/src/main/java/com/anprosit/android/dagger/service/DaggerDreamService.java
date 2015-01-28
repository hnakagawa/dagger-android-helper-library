package com.anprosit.android.dagger.service;

import android.annotation.TargetApi;
import android.os.Build;
import android.service.dreams.DreamService;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author KeithYokoma
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public abstract class DaggerDreamService extends DreamService implements DaggerContext {
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

	protected abstract List<Object> getModules();

	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}
