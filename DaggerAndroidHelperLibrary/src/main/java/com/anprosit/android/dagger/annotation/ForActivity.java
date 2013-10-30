package com.anprosit.android.dagger.annotation;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Qualifier
@Retention(RUNTIME)
public @interface ForActivity {
}
