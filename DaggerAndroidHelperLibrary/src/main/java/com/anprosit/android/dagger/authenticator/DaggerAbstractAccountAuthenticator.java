package com.anprosit.android.dagger.authenticator;

import android.accounts.AbstractAccountAuthenticator;
import android.content.Context;

import com.anprosit.android.dagger.DaggerContext;

/**
 * Created by hnakagawa on 14/03/01.
 */
public abstract class DaggerAbstractAccountAuthenticator extends AbstractAccountAuthenticator {
	public DaggerAbstractAccountAuthenticator(Context context) {
		super(context);
		DaggerContext application = (DaggerContext) context.getApplicationContext();
		application.getObjectGraph().inject(this);
	}
}
