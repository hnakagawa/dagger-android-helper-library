package com.anprosit.dagger.example;

import dagger.Module;

/**
 * Created by Hirofumi Nakagawa on 13/09/01.
 */
@Module(
		injects = {
				ExampleApplication.class
		},
		complete = false,
		library = true
)
public class ExampleApplicationModule {
}
