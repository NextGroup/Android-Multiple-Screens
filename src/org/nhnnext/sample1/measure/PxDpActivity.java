package org.nhnnext.sample1.measure;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;

public class PxDpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ScrollView sv = new ScrollView(this);
		
		LinearLayout llGroup = new LinearLayout(this);
		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		llGroup.setOrientation(LinearLayout.HORIZONTAL);
		llGroup.setLayoutParams(params);
		sv.addView(llGroup);

		
		params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1);
		
		LinearLayout llPx = new LinearLayout(this);
		llPx.setOrientation(LinearLayout.VERTICAL);
		llPx.setLayoutParams(params);
		llGroup.addView(llPx);
		
		LinearLayout llDp = new LinearLayout(this);
		llDp.setOrientation(LinearLayout.VERTICAL);
		llDp.setLayoutParams(params);
		llGroup.addView(llDp);
		
		TextView tv;
		for(int i=0; i<50; i++) {
			tv = new TextView(this);
			tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, i);
			tv.setText(i + " PX");
			llPx.addView(tv);

			tv = new TextView(this);
			tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, i);
			tv.setText(i + " DIP(DP)");
			llDp.addView(tv);
		}
		
		setContentView(sv);
	}

}
