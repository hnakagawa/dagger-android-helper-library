package com.anprosit.android.dagger.factory;

import android.media.MediaRecorder;

/**
 * Created by Hirofumi Nakagawa on 13/08/23.
 */
public class MediaRecorderFactory {
	public MediaRecorder create() {
		return new MediaRecorder();
	}
}
