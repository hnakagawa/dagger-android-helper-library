package com.anprosit.android.dagger.factory;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

/**
 * @author hnakagawa
 */
public class MediaPlayerFactory {
	public MediaPlayer create(Context context, int resId) {
		return MediaPlayer.create(context, resId);
	}

	public MediaPlayer create(Context context, Uri uri) {
		return MediaPlayer.create(context, uri);
	}

	public MediaPlayer create() {
		return new MediaPlayer();
	}
}
