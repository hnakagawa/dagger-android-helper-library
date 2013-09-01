package com.anprosit.dagger.android.ui;

import android.app.Activity;
import android.os.Bundle;

import com.anprosit.dagger.android.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/27.
 */
public abstract class DaggerActivity extends Activity {
	private DaggerHelper mHelper = new DaggerHelper();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mHelper.onCreate(this, getModules());
	}

	@Override
	protected void onDestroy() {
		mHelper.onDestroy();
		super.onDestroy();
	}

	protected abstract List<Object> getModules();

	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	public ObjectGraph getActivityGraph() {
		return mHelper.getObjectGraph();
	}
}
