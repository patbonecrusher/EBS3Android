package com.example.pat.ebs3_android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
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

    public static int counter = 0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String message = getArguments().getString("message");
        String tableViewInfo = getArguments().getString("tableViewInfo");
        String formViewInfo = getArguments().getString("formViewInfo");

        RelativeLayout rl = new RelativeLayout(this.getContext());
        RelativeLayout.LayoutParams prl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rl.setLayoutParams(prl);
        rl.setBackgroundColor(Color.RED);

            LinearLayout ll = new LinearLayout(this.getContext());
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams pll = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            ll.setLayoutParams(pll);
            ll.setBackgroundColor(Color.BLACK);

                LinearLayout lll = new LinearLayout(this.getContext());
                lll.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams plll = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 2);
                lll.setLayoutParams(plll);
                lll.setBackgroundColor(Color.RED);
                ll.addView(lll);

                LinearLayout llf = new LinearLayout(this.getContext());
                llf.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1));
                llf.setOrientation(LinearLayout.HORIZONTAL);
                llf.setId(12345+(counter++));

                FragmentManager fragMan = getFragmentManager();
                FragmentTransaction fragTransaction = fragMan.beginTransaction();

                MyListFragment mlf = new MyListFragment();
                fragTransaction.add(llf.getId(), mlf , "fragment");
                fragTransaction.commit();

                lll.addView(llf);

                LinearLayout llr = new LinearLayout(this.getContext());
                llr.setOrientation(LinearLayout.VERTICAL);
                LinearLayout.LayoutParams pllr = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
                llr.setLayoutParams(pllr);
                llr.setBackgroundColor(Color.BLUE);
                ll.addView(llr);

//            final TextView tv1 = new TextView(this.getContext());
//            tv1.setId(View.generateViewId());
//            tv1.setText(message);
//            tv1.setTextAppearance(android.R.style.TextAppearance_Large);
//
//            RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            params.addRule(RelativeLayout.CENTER_IN_PARENT);
//            tv1.setLayoutParams(params);
//            ll.addView(tv1);
//
//            final TextView tv2 = new TextView(this.getContext());
//            tv2.setId(View.generateViewId());
//            tv2.setText(message);
//            tv2.setTextAppearance(android.R.style.TextAppearance_Large);
//
//            RelativeLayout.LayoutParams params2= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            params2.addRule(RelativeLayout.CENTER_IN_PARENT);
//            tv1.setLayoutParams(params2);
//            ll.addView(tv2);

        rl.addView(ll);

        return rl;
    }
}
