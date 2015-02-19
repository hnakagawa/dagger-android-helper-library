package com.anprosit.android.dagger.receiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author hnakagawa
 */
public abstract class DaggerBroadcastReceiver extends BroadcastReceiver {
	@Override
	public final void onReceive(Context context, Intent intent) {
		((DaggerContext) context.getApplicationContext()).getObjectGraph().inject(this);
		onHandleIntent((Application) context.getApplicationContext(), intent);
	}

	public abstract void onHandleIntent(Application application, Intent intent);
}
