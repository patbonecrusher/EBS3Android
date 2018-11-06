package com.example.pat.ebs3_android.ebclasses;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;

import com.example.pat.ebs3_android.EBPagerAdapter;
import com.example.pat.ebs3_android.EBSplitViewFragment;

import org.liquidplayer.javascript.JSArray;
import org.liquidplayer.javascript.JSContext;
import org.liquidplayer.javascript.JSObject;
import org.liquidplayer.javascript.JSValue;

public class EBUIBuilder extends JSObject {
    private TabLayout tabLayout;
    private EBPagerAdapter pagerAdapter;

    public EBUIBuilder(TabLayout tabLayout, EBPagerAdapter pagerAdapter, JSContext ctx) {
        super(ctx);
        this.tabLayout = tabLayout;
        this.pagerAdapter = pagerAdapter;
    }

    @jsexport(type = Integer.class)
    Property<Integer> x;

    @jsexport(type = String.class)
    Property<String>  y;

    @jsexport(attributes = JSPropertyAttributeReadOnly)
    Property<String> read_only;

    @SuppressWarnings("unused")
    @jsexport(attributes = JSPropertyAttributeReadOnly | JSPropertyAttributeDontDelete)
    void buildUI(JSArray<JSValue> objs) {
        System.out.println(">>>> " + objs);
        for (JSValue var : objs)
        {
            //JSObjectPropertiesMap x = new JSObjectPropertiesMap(var.toObject(), TabInfo.class);
            System.out.println(">>>> " + var.isObject());
            JSObject x = var.toObject();
            System.out.println(">>>> " + x.hasProperty("tabName") + ": " + x.property("tabName"));

            String tabName = x.property("tabName").toString();
            String tableView = x.property("tableView").toJSON();
            String formView = x.property("formView").toJSON();


            tabLayout.addTab(tabLayout.newTab().setText(tabName));
            pagerAdapter.addFragment(EBSplitViewFragment.newInstance(tabName, tableView, formView));

            // int xx = bottomTab.getMenu().size();
            // bottomTab.getMenu().add(Menu.NONE, xx+1, xx+1, x.property("tabName").toString());
            // bottomTab.getMenu().add(x.property("tabName").toString());

        }

    }

}