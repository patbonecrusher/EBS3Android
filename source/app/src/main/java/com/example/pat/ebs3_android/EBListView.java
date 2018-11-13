package com.example.pat.ebs3_android;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
            String fieldName = obj.getString("cellFieldName");
            JSONArray data = obj.getJSONArray("data");

            List<String> where = new ArrayList<String>();

            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonobject = data.getJSONObject(i);
                String name = jsonobject.getString(fieldName);
                where.add(name);
            }

            String[] values = new String[ where.size() ];
            where.toArray( values );
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);

            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setSelector(R.drawable.list_level_selector);

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2" };
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
//    	 Toast.makeText(getActivity(), "setActivateOnItemClick", Toast.LENGTH_SHORT).show();
        getListView().setChoiceMode(activateOnItemClick ? ListView.CHOICE_MODE_SINGLE : ListView.CHOICE_MODE_NONE);
        getListView().setSelector(R.drawable.list_level_selector);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if (listener != null) listener.onItemSelected(id);
        getListView().setItemChecked(position, true);
        getListView().setSelection(position);
        getListView().setSelected(true);
    }
}
