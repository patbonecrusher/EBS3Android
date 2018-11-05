package com.example.pat.ebs3_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final RelativeLayout relativeLayout = new RelativeLayout(this);
//        final TextView tv1;
//        tv1 = new TextView(this);
//        tv1.setText("tv1");
//        // Setting an ID is mandatory.
//        tv1.setId(View.generateViewId());
//        relativeLayout.addView(tv1);
//
//        final TextView tv2;
//        tv2 = new TextView(this);
//        tv2.setText("tv2");
//        tv2.setId(View.generateViewId());
//        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//        lp.addRule(RelativeLayout.RIGHT_OF, tv1.getId());
//        relativeLayout.addView(tv2, lp);
//
//        final TextView tv3;
//        tv3 = new TextView(this);
//        tv3.setText("tv3");
//        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(
//                ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        );
//        lp2.addRule(RelativeLayout.RIGHT_OF, tv2.getId());
//        relativeLayout.addView(tv3, lp2);

        this.setContentView(relativeLayout);

        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);


    }
}
