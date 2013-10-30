package com.anprosit.dagger.example;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.anprosit.android.dagger.ActivityModule;
import com.anprosit.android.dagger.ui.DaggerActivity;
import com.anprosit.dagger.android.example.R;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends DaggerActivity {
	@Inject
	Greeting mGreeting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bUtton = (Button)findViewById(R.id.button);
		bUtton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mGreeting.say();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected List<Object> getModules() {
		return Arrays.asList(new ActivityModule(this), new ExampleActivityModule());
	}
}
