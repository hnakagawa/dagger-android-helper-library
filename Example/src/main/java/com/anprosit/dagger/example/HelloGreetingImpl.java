package com.anprosit.dagger.example;

import android.content.Context;
import android.widget.Toast;

import com.anprosit.android.dagger.annotation.ForActivity;

import javax.inject.Inject;

/**
 * Created by Hirofumi Nakagawa on 13/09/01.
 */
public class HelloGreetingImpl implements Greeting {
	private final Context mContext;

	@Inject
	public HelloGreetingImpl(@ForActivity Context context) {
		mContext = context;
	}

	@Override
	public void say() {
		Toast.makeText(mContext, "Hello!!", Toast.LENGTH_SHORT).show();
	}
}
