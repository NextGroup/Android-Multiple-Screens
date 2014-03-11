package org.nhnnext.sample4.layoutadvanced;

import java.lang.reflect.Method;

import org.nhnnext.sample.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.widget.TextView;

public class RuntimeActivity extends Activity {

	// smallest width calc : http://stackoverflow.com/questions/14616881/smallest-width-layouts-bug-in-nexus-7
	
	/*
	 * Layout Configuration (Folder로 구분) 부분 잘 이해할 것.
	 * Configuration 값에 따라 우선순위가 존재함.
	 * 보통 Configuration에 명시한 값의  same or higher
	 * 
	 */

	public static Point getRealSize(Display display) {
		Point outPoint = new Point();
		Method mGetRawH;
		try {
			mGetRawH = Display.class.getMethod("getRawHeight");
			Method mGetRawW = Display.class.getMethod("getRawWidth");
			outPoint.x = (Integer) mGetRawW.invoke(display);
			outPoint.y = (Integer) mGetRawH.invoke(display);
			return outPoint;
		} catch (Throwable e) {
			return null;
		}
	}

	@SuppressLint("NewApi")
	public static Point getSize(Display display) {
		Point outPoint = new Point();
		if (Build.VERSION.SDK_INT >= 17) {
			DisplayMetrics metrics = new DisplayMetrics();
			display.getRealMetrics(metrics);
			outPoint.x = metrics.widthPixels;
			outPoint.y = metrics.heightPixels;
		} else if (Build.VERSION.SDK_INT >= 14) {
			outPoint = getRealSize(display);
		} else if (Build.VERSION.SDK_INT >= 13) {
			display.getSize(outPoint);
		} else {
			outPoint.x = display.getWidth();
			outPoint.y = display.getHeight();
		}
		return outPoint;
	}
	
	private String getScreenStats() {
	    
		Display display = getWindowManager().getDefaultDisplay();
	    
		DisplayMetrics metrics = getResources().getDisplayMetrics();
	    
	    Point pxSize = getSize(display);
	    
	    Point dpSize = new Point();
	    dpSize.x = (int) (pxSize.x / metrics.density);
	    dpSize.y = (int) (pxSize.y / metrics.density);

	    StringBuilder sb = new StringBuilder();
	    sb.append(Build.MANUFACTURER);
	    sb.append(", ");
	    sb.append(Build.MODEL);
	    sb.append("\n\n");
	    
	    sb.append("Pixels: ");
	    sb.append(pxSize.x);
	    sb.append(" x " );
	    sb.append(pxSize.y);
	    sb.append("\n\n");
	    
	    sb.append("Dp (px / density): ");
	    sb.append(dpSize.x);
	    sb.append(" x " );
	    sb.append(dpSize.y);
	    sb.append("\n\n");
	    
	    sb.append("smallest width: " + Math.min(pxSize.x, dpSize.x));
	    sb.append("\n\n");
	    
	    sb.append("density: ");
	    sb.append(metrics.densityDpi);
	    sb.append("dpi, ");
	    sb.append(metrics.density);

	    return sb.toString();
	}
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layoutfloder);

		TextView tvInfo = (TextView) findViewById(R.id.tvInfo);
		tvInfo.setText(getScreenStats());

		Point pxSize = getSize(getWindowManager().getDefaultDisplay());
		int dimensPx = pxSize.x / 20;
		int dimensDp = (int) (dimensPx / getResources().getDisplayMetrics().density);
		TextView tvTag = (TextView) findViewById(R.id.tvTag);
		tvTag.setTextSize(TypedValue.COMPLEX_UNIT_PX, dimensPx);
		tvTag.setText(tvTag.getText() + ", "+dimensPx+"px ("+dimensDp+"dp)\nRuntime");

		/*
		 * 왜 갤럭시 S2에는 sw320dp가 뜨지 않을까?
		 * 그 이유는 간단하다. sw<N>dp 는 API level 13부터 추가되었기 때문이다.
		 * 그래서 dp 기준으로 size가 320dp 임에도 불구하고 layout만 보이는 것이다.
		 * 
		 * 우선순위는 다음과 같다.
		 *  Language > Version > Smallest width > Orientation
		 * 
		int Measuredwidth = 0;
		int Measuredheight = 0;
		Point size = new Point();
		WindowManager wm = getWindowManager();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			wm.getDefaultDisplay().getSize(size);

			Measuredwidth = size.x;
			Measuredheight = size.y;
		} else {
			Display d = wm.getDefaultDisplay();
			Measuredwidth = d.getWidth();
			Measuredheight = d.getHeight();
		}
		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);

		float density = getResources().getDisplayMetrics().density;
		float dpHeight = outMetrics.heightPixels / density;
		float dpWidth = outMetrics.widthPixels / density;

		Toast.makeText(this, dpWidth + "", Toast.LENGTH_LONG).show();
		*/
	}
}
