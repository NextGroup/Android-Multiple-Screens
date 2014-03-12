package org.nhnnext.sample7.fragment;

import org.nhnnext.sample.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SampleFragment2 extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View vg = inflater.inflate(R.layout.activity_profile2, container, false);
		
		return vg;
	}
	
}
