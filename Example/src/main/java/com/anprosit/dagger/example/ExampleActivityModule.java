package com.anprosit.dagger.example;

import android.content.Context;

import com.anprosit.android.dagger.annotation.ForActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Hirofumi Nakagawa on 13/09/01.
 */
@Module(
		injects = {
				MainActivity.class
		},
		complete = false,
		library = true
)
public class ExampleActivityModule {

	@Provides
	@Singleton
	Greeting provideGreeting(@ForActivity Context context) {
		return new HelloGreetingImpl(context);
	}
}
