package com.anprosit.dagger.android.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.anprosit.dagger.android.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
public abstract class DaggerFragmentActivity extends FragmentActivity {
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
