package com.anprosit.dagger.example;

import com.anprosit.dagger.android.ApplicationModule;
import com.anprosit.dagger.android.application.DaggerApplication;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Hirofumi Nakagawa on 13/09/01.
 */
public class ExampleApplication extends DaggerApplication {
	@Override
	protected List<Object> getModules() {
		return Arrays.asList(new ApplicationModule(this), new ExampleApplicationModule());
	}
}
