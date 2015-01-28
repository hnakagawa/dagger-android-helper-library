package com.anprosit.android.dagger.receiver;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.anprosit.android.dagger.application.DaggerApplication;

/**
 * @author KeithYokoma
 */
public abstract class DaggerWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
	@Override
	public final void onReceive(Context context, Intent intent) {
		DaggerApplication application = (DaggerApplication) context.getApplicationContext();
		application.getObjectGraph().inject(this);
		onHandleIntent(application, intent);
	}

	public abstract void onHandleIntent(Application application, Intent intent);
}
