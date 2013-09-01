package com.anprosit.dagger.android.receiver;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.anprosit.dagger.android.application.DaggerApplication;

/**
 * Created by Hirofumi Nakagawa on 13/08/15.
 */
public abstract class DaggerBroadcastReceiver extends BroadcastReceiver {
	@Override
	public final void onReceive(Context context, Intent intent) {
		DaggerApplication application = (DaggerApplication) context.getApplicationContext();
		application.getApplicationGraph().inject(this);
		onHandleIntent(application, intent);
	}

	public abstract void onHandleIntent(Application application, Intent intent);
}
