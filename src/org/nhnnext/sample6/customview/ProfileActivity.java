package org.nhnnext.sample6.customview;

import org.nhnnext.sample.R;

import android.app.Activity;
import android.os.Bundle;

public class ProfileActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_profile);
		
//		ProfileView pv = new ProfileView(this);
//		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//		pv.setLayoutParams(params);
//		
//		setContentView(pv);
	}
	
}
