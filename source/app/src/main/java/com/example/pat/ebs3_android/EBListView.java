package com.example.pat.ebs3_android;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class EBListView extends ListFragment {

    public interface EBListViewListener {
        // These methods are the different events and
        // need to pass relevant arguments related to the event triggered
        public void onItemSelected(long id);
    }

    private EBListViewListener listener;

    public EBListView() {
        this.listener = null;
    }

    public void setCustomObjectListener(EBListViewListener listener) {
        this.listener = listener;
    }

    public static final EBListView newInstance(String tableViewInfo) {
        EBListView adf =  new EBListView();
        Bundle bundle = new Bundle(1);
        bundle.putString("tableViewInfo", tableViewInfo);
        adf.setArguments(bundle);
        return adf;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String tableViewInfo = getArguments().getString("tableViewInfo");

        JSONObject obj = null;
        try {
            obj = new JSONObject(tableViewInfo);
            //String pageName = obj.getJSONObject("data").getString("pageName");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) listener.onItemSelected(id);
    }
}
