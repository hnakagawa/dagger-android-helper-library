package com.anprosit.android.dagger.ui.v7;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.anprosit.android.dagger.DaggerContext;
import com.anprosit.android.dagger.helper.DaggerHelper;

import java.util.List;

import dagger.ObjectGraph;

/**
 * @author KeithYokoma
 * @deprecated Since {@link ActionBarActivity} is deprecated, this base class is also deprecated. Use {@link DaggerAppCompatActivity} instead.
 */
@Deprecated
public abstract class DaggerActionBarActivity extends ActionBarActivity implements DaggerContext {
	private DaggerHelper mHelper = new DaggerHelper();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mHelper.onCreate(this, getModules());
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mHelper.onDestroy();
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
