package com.anprosit.dagger.android;

import android.app.Service;
import android.content.Context;

import com.anprosit.dagger.android.annotation.ForService;
import com.anprosit.dagger.android.service.DaggerService;

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
		return ((DaggerService) mService).getServiceGraph();
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
