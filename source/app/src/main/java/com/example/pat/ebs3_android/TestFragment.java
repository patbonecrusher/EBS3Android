package com.example.pat.ebs3_android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestFragment extends Fragment {
    String mMessage;
    public TestFragment() {

    }
    public TestFragment(String message) {
        this.mMessage = message;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout rl = new RelativeLayout(this.getContext());
        RelativeLayout.LayoutParams prl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rl.setLayoutParams(prl);
        rl.setBackgroundColor(Color.RED);

        final TextView tv = new TextView(this.getContext());
        tv.setId(View.generateViewId());
        tv.setText(this.mMessage);
        tv.setTextAppearance(android.R.style.TextAppearance_Large);

        RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        tv.setLayoutParams(params);

        rl.addView(tv);

        return rl;
    }
}
