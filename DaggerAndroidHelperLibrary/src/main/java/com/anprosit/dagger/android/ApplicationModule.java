package com.anprosit.dagger.android;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.speech.SpeechRecognizer;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.anprosit.dagger.android.annotation.ForApplication;
import com.anprosit.dagger.android.application.DaggerApplication;
import com.anprosit.dagger.android.factory.MediaRecorderFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 */
@Module(
		library = true
)
public class ApplicationModule {
	private final Application mApplication;

	public ApplicationModule(Application application) {
		mApplication = application;
	}

	@Provides
	@Singleton
	ObjectGraph provideApplicationGraph() {
		return ((DaggerApplication) mApplication).getApplicationGraph();
	}

	@Provides
	@Singleton
	@ForApplication
	Context provideApplicationContext() {
		return mApplication;
	}

	@Provides
	@Singleton
	Application provideApplication() {
		return mApplication;
	}

	@Provides
	Handler provideHandler() {
		return new Handler(Looper.getMainLooper());
	}

	@Provides
	@Singleton
	SmsManager provideSmsManager() {
		return SmsManager.getDefault();
	}

	@Provides
	@Singleton
	TelephonyManager provideTelephonyManager() {
		return (TelephonyManager) mApplication.getSystemService(Context.TELEPHONY_SERVICE);
	}

	@Provides
	@Singleton
	WindowManager provideWindowManager() {
		return (WindowManager) mApplication.getSystemService(Context.WINDOW_SERVICE);
	}

	@Provides
	@Singleton
	Vibrator provideVibrator() {
		return (Vibrator) mApplication.getSystemService(Context.VIBRATOR_SERVICE);
	}

	@Provides
	SpeechRecognizer provideSpeechRecognizer() {
		return SpeechRecognizer.createSpeechRecognizer(mApplication);
	}

	@Provides
	@Singleton
	SensorManager provideSensorManager() {
		return (SensorManager) mApplication.getSystemService(Context.SENSOR_SERVICE);
	}

	@Provides
	@Singleton
	BluetoothAdapter provideBluetoothAdapter() {
		return BluetoothAdapter.getDefaultAdapter();
	}

	@Provides
	@Singleton
	LocationManager provideLocationManager() {
		return (LocationManager) mApplication.getSystemService(Context.LOCATION_SERVICE);
	}

	@Provides
	@Singleton
	MediaRecorderFactory provideMediaRecorderFactory() {
		return new MediaRecorderFactory();
	}

	@Provides
	@Singleton
	AudioManager provideAudioManager() {
		return (AudioManager) mApplication.getSystemService(Context.AUDIO_SERVICE);
	}

	@Provides
	@Singleton
	LayoutInflater provideLayoutInflater() {
		return (LayoutInflater) mApplication.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
}
