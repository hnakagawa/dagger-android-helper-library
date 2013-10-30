package com.anprosit.android.dagger;

import android.app.Service;
import android.content.Context;

import com.anprosit.android.dagger.annotation.ForService;
import com.anprosit.android.dagger.service.DaggerService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 * Created by Hirofumi Nakagawa on 13/07/27.
 */
@Module(
		complete = false,
		library = true
)
public class ServiceModule {
	private final Service mService;

	public ServiceModule(Service service) {
		mService = service;
	}

	@Provides
	@Singleton
	ObjectGraph provideServiceGraph() {
		return ((DaggerService) mService).getObjectGraph();
	}

	@Provides
	@Singleton
	@ForService
	Context provideServiceContext() {
		return mService;
	}

	@Provides
	@Singleton
	Service provideService() {
		return mService;
	}
}
