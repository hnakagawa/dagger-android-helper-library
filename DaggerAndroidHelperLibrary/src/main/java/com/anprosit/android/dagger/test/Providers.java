package com.anprosit.android.dagger.test;


import javax.inject.Provider;

public class Providers {
	public static <T> Provider<T> of(final T t) {
		return new Provider<T>() {
			public T get() {
				return t;
			}
		};
	}
}
