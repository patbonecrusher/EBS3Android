package com.example.pat.ebs3_android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.liquidplayer.javascript.JSObject;

public class EBSplitViewFragment extends Fragment {
    public EBSplitViewFragment() {

    }

    public static final EBSplitViewFragment newInstance(String message, String tableViewInfo, String formViewInfo) {
        EBSplitViewFragment adf =  new EBSplitViewFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString("message", message);
        bundle.putString("tableViewInfo", tableViewInfo);
        bundle.putString("formViewInfo", formViewInfo);
        adf.setArguments(bundle);
        return adf;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String message = getArguments().getString("message");
        String tableViewInfo = getArguments().getString("tableViewInfo");
        String formViewInfo = getArguments().getString("formViewInfo");

        RelativeLayout rl = new RelativeLayout(this.getContext());
        RelativeLayout.LayoutParams prl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rl.setLayoutParams(prl);
        rl.setBackgroundColor(Color.RED);

        final TextView tv = new TextView(this.getContext());
        tv.setId(View.generateViewId());
        tv.setText(message);
        tv.setTextAppearance(android.R.style.TextAppearance_Large);

        RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        tv.setLayoutParams(params);

        rl.addView(tv);

        return rl;
    }
}
