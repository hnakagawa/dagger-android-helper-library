package com.anprosit.android.dagger.factory;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Hirofumi Nakagawa on 13/09/06.
 */
public class MediaPlayerFactory {
	public MediaPlayer create(Context context, int resId) {
		return MediaPlayer.create(context, resId);
	}

	public MediaPlayer create() {
		return new MediaPlayer();
	}
}
