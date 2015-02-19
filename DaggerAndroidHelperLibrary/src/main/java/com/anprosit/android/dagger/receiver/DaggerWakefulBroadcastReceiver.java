package com.anprosit.android.dagger.receiver;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.anprosit.android.dagger.DaggerContext;

/**
 * @author KeithYokoma
 */
public abstract class DaggerWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
	@Override
	public final void onReceive(Context context, Intent intent) {
		((DaggerContext) context.getApplicationContext()).getObjectGraph().inject(this);
		onHandleIntent((Application) context.getApplicationContext(), intent);
	}

	public abstract void onHandleIntent(Application application, Intent intent);
}
