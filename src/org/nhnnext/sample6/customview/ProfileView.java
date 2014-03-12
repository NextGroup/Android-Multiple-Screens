package org.nhnnext.sample6.customview;

import org.nhnnext.sample.R;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProfileView extends LinearLayout {

	public ProfileView(Context context) {
		super(context);
		initialize(context);
	}
	
	public ProfileView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize(context);
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public ProfileView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize(context);
	}
	
	private ImageView ivPhoto;
	private TextView tvName;

	public void initialize(Context context) {
		LayoutInflater li = ((Activity)context).getLayoutInflater();
		li.inflate(R.layout.view_profile, this);

		ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
		tvName = (TextView) findViewById(R.id.tvName);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        
        // height 진짜 크기 구하기
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = 0;
        switch(heightMode) {
        case MeasureSpec.UNSPECIFIED:    // mode 가 셋팅되지 않은 크기가 넘어올때
            heightSize = heightMeasureSpec;
            break;
        case MeasureSpec.AT_MOST:        // wrap_content (뷰 내부의 크기에 따라 크기가 달라짐)
            heightSize = 20;
            break;
        case MeasureSpec.EXACTLY:        // fill_parent, match_parent (외부에서 이미 크기가 지정되었음)
            heightSize = MeasureSpec.getSize(heightMeasureSpec);
            break;
        }
        
        // width 진짜 크기 구하기
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = 0;
        switch(widthMode) {
        case MeasureSpec.UNSPECIFIED:    // mode 가 셋팅되지 않은 크기가 넘어올때
            widthSize = widthMeasureSpec;
            break;
        case MeasureSpec.AT_MOST:        // wrap_content (뷰 내부의 크기에 따라 크기가 달라짐)
            widthSize = 100;
            break;
        case MeasureSpec.EXACTLY:        // fill_parent, match_parent (외부에서 이미 크기가 지정되었음)
            widthSize = MeasureSpec.getSize(widthMeasureSpec);
            break;
        }

        setMeasuredDimension(widthSize, heightSize);

        if(widthSize < heightSize)
        	tvName.setTextSize(widthSize/20);
        else
        	tvName.setTextSize(heightSize/20);
	}
	

}
