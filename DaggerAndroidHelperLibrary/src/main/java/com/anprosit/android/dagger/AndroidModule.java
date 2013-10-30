package com.anprosit.android.dagger;

import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.nfc.NfcAdapter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Vibrator;
import android.speech.SpeechRecognizer;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.anprosit.android.dagger.annotation.ForApplication;
import com.anprosit.android.dagger.application.DaggerApplication;
import com.anprosit.android.dagger.factory.MediaPlayerFactory;
import com.anprosit.android.dagger.factory.MediaRecorderFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
 * Created by Hirofumi Nakagawa on 13/07/21.
 * <p/>
 * Global module for Android application
 */
@Module(
		library = true
)
public class AndroidModule {
	private final Application mApplication;

	public AndroidModule(Application application) {
		mApplication = application;
	}

	@Provides
	@Singleton
	ObjectGraph provideApplicationGraph() {
		return ((DaggerApplication) mApplication).getObjectGraph();
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
	MediaPlayerFactory provideMediaPlayer() {
		return new MediaPlayerFactory();
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

	@Provides
	@Singleton
	PowerManager provodePowerManager() {
		return (PowerManager) mApplication.getSystemService(Context.POWER_SERVICE);
	}

	@Provides
	@Singleton
	@TargetApi(10)
	NfcAdapter provideNfcAdapter() {
		return NfcAdapter.getDefaultAdapter(mApplication);
	}
}
