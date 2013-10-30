package com.anprosit.android.dagger.utils;

import android.content.Context;

import com.anprosit.android.dagger.DaggerContext;

import dagger.ObjectGraph;

/**
 * Created by hnakagawa on 13/10/21.
 */
public final class ObjectGraphUtils {
	private ObjectGraphUtils() {}

	public static ObjectGraph getObjectGraph(Context context) {
		if (context instanceof DaggerContext)
			return ((DaggerContext)context).getObjectGraph();
		throw new IllegalArgumentException();
	}
}
