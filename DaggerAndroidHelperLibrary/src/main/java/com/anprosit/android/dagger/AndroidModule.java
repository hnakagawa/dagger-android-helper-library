package com.anprosit.android.dagger;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.UiModeManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.nfc.NfcAdapter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Vibrator;
import android.speech.SpeechRecognizer;
import android.support.v4.app.NotificationManagerCompat;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.anprosit.android.dagger.annotation.ForApplication;
import com.anprosit.android.dagger.factory.MediaPlayerFactory;
import com.anprosit.android.dagger.factory.MediaRecorderFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;

/**
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
	@ForApplication
	ObjectGraph provideApplicationGraph() {
		return ((DaggerContext) mApplication).getObjectGraph();
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
	PackageManager providePackageManager() {
		return mApplication.getPackageManager();
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

	@Provides
	@Singleton
	ActivityManager provideActividyManager() {
		return (ActivityManager)mApplication.getSystemService(Context.ACTIVITY_SERVICE);
	}

	@Provides
	@Singleton
	KeyguardManager provideKeygurdManager() {
		return (KeyguardManager)mApplication.getSystemService(Context.KEYGUARD_SERVICE);
	}

	@Provides
	@Singleton
	UiModeManager provideUiModeManager() {
		return (UiModeManager) mApplication.getSystemService(Context.UI_MODE_SERVICE);
	}

	@Provides
	@Singleton
	@TargetApi(11)
	ClipboardManager provideClipboardManager() {
		return (ClipboardManager)mApplication.getSystemService(Context.CLIPBOARD_SERVICE);
	}

	@Provides
	@Singleton
	NotificationManager provideNotificationManager() {
		return (NotificationManager) mApplication.getSystemService(Context.NOTIFICATION_SERVICE);
	}

	@Provides
	@Singleton
	AppWidgetManager provideAppWidgetManager() {
		return (AppWidgetManager) AppWidgetManager.getInstance(mApplication);
	}

	@Provides
	NotificationManagerCompat provideNotificationManagerCompat() {
		return NotificationManagerCompat.from(mApplication);
	}
}
