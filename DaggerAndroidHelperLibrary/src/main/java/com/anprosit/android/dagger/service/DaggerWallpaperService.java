package com.anprosit.android.dagger.service;

import android.service.wallpaper.WallpaperService;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author KeithYokoma
 */
public abstract class DaggerWallpaperService extends WallpaperService implements DaggerContext {
	private DaggerHelper mHelper = new DaggerHelper();

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

	protected abstract List<Object> getModules();

	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}
