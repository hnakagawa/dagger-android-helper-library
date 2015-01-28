package com.anprosit.android.dagger.ui.v7;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author KeithYokoma
 */
public abstract class DaggerActionBarActivity extends ActionBarActivity implements DaggerContext {
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

	@Override
	public <T> T inject(T obj) {
		return mHelper.inject(obj);
	}

	@Override
	public ObjectGraph getObjectGraph() {
		return mHelper.getObjectGraph();
	}
}
