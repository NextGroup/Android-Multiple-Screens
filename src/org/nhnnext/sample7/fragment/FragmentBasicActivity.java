package org.nhnnext.sample7.fragment;

import org.nhnnext.sample.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class FragmentBasicActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_fragment);
		
		SampleFragment sampleFragment = new SampleFragment();
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.vgContent, sampleFragment).commit();
		
	}
	
}

/*
import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class FragmentSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_fragment);
		
		SampleFragment sampleFragment = new SampleFragment();
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.vgContent, sampleFragment).commit();
		
	}
	
}
*/