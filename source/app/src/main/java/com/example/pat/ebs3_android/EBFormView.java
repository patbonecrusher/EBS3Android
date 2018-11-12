package com.example.pat.ebs3_android;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EBFormView extends Fragment {

    public static final EBFormView newInstance(String id) {
        EBFormView efv =  new EBFormView();
        Bundle bundle = new Bundle(1);
        bundle.putString("id", id);
        efv.setArguments(bundle);
        return efv;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // View v = super.onCreateView(inflater, container, savedInstanceState);

        String id = getArguments().getString("id");
        System.out.println(id);

        LinearLayout ll = new LinearLayout(this.getContext());
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams pll = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(pll);
        ll.setBackgroundColor(Color.YELLOW);

        TextView ProgrammaticallyTextView = new TextView(this.getContext());
        ProgrammaticallyTextView.setText(id);
        ProgrammaticallyTextView.setTextSize(22);
        ProgrammaticallyTextView.setPadding(20, 20, 100, 50);
        ll.addView(ProgrammaticallyTextView);

        return ll;
    }
}
