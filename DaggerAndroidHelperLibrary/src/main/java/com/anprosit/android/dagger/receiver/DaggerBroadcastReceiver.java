package com.anprosit.android.dagger.receiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.anprosit.android.dagger.application.DaggerApplication;

/**
 * Created by Hirofumi Nakagawa on 13/08/15.
 */
public abstract class DaggerBroadcastReceiver extends BroadcastReceiver {
	@Override
	public final void onReceive(Context context, Intent intent) {
		DaggerApplication application = (DaggerApplication) context.getApplicationContext();
		application.getObjectGraph().inject(this);
		onHandleIntent(application, intent);
	}

	public abstract void onHandleIntent(Application application, Intent intent);
}
