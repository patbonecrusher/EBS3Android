package com.example.pat.ebs3_android.ebclasses;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;

import org.liquidplayer.javascript.JSArray;
import org.liquidplayer.javascript.JSContext;
import org.liquidplayer.javascript.JSObject;
import org.liquidplayer.javascript.JSValue;

//public class EBUIBuilder {
//    private ConstraintLayout view;
//    private Context context;
//    public EBUIBuilder(ConstraintLayout view, Context context) {
//        this.view = view;
//        this.context = context;
//    }
//
//    public void drawLabel(Integer x, Integer  y, Integer  height, Integer  width, String label) {
//        System.out.printf("x: %d, y: %d, height: %d, width: %d, label: %s\n", x, y, height, width, label);
//
//        TextView ProgrammaticallyTextView = new TextView(this.context);
//        ProgrammaticallyTextView.setText(label);
//        ProgrammaticallyTextView.setTextSize(22);
//        ProgrammaticallyTextView.setPadding(x, y, width, height);
//        view.addView(ProgrammaticallyTextView);
//    }
//
//    public void buildUI() {
//
//    }
//
//    public V8Object constructV8Object(V8 runtime) {
//        V8Object v8Generator = new V8Object(runtime);
//
//        // runtime.add("console", v8Console);
//        v8Generator.registerJavaMethod(this, "drawLabel", "drawLabel", new Class<?>[] {
//                Integer.class,
//                Integer.class,
//                Integer.class,
//                Integer.class,
//                String.class,
//        });
//
//        return v8Generator;
//    }
//}

//    JavaVoidCallback callback = new JavaVoidCallback() {
//        public void invoke(final V8Object receiver, final V8Array parameters) {
//            if (parameters.length() > 0) {
//                Object arg1 = parameters.get(0);
//                System.out.println(arg1);
//                if (arg1 instanceof Releasable) {
//                    ((Releasable) arg1).release();
//                }
//            }
//        }
//    };
// v8.registerJavaMethod(callback, "print");
//         v8.executeScript("print('hello, world');");

//        tabName: "Templates",
//                tableView: {title: "Templates",   data: templates,   cellFieldName: "TemplateName",  buttons:"Edit, +"},
//                formView:  {title: "Template details", xml: "TemplateForm", buttons: ",Edit"}
//
//class TabInfo extends JSValue {
//    public TabInfo(JSContext ctx) { super(ctx); }
//
//    public String tabName;
//    public JSObject tableView;
//    public JSObject formView;
//}

public class EBUIBuilder extends JSObject {
    private TabLayout tabLayout;
    private BottomNavigationView bottomTab;

    public EBUIBuilder(TabLayout tabLayout, BottomNavigationView bottomTab, JSContext ctx) {
        super(ctx);
        this.tabLayout = tabLayout;
        this.bottomTab = bottomTab;
    }

    public EBUIBuilder(TabLayout tabLayout, JSContext ctx) {
        super(ctx);
        this.tabLayout = tabLayout;
        this.bottomTab = bottomTab;
    }

    @jsexport(type = Integer.class)
    Property<Integer> x;

    @jsexport(type = String.class)
    Property<String>  y;

    @jsexport(attributes = JSPropertyAttributeReadOnly)
    Property<String> read_only;
//
//    @SuppressWarnings("unused")
//    @jsexport(attributes = JSPropertyAttributeReadOnly | JSPropertyAttributeDontDelete)
//    void buildUI(JSArray<TabInfo> objs) {
//        System.out.println(">>>> " + objs);
//        for (TabInfo var : objs)
//        {
//            //System.out.println(">>>> " + var.tabName);
//        }
//
//    }

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
            tabLayout.addTab(tabLayout.newTab().setText(x.property("tabName").toString()));

            // int xx = bottomTab.getMenu().size();
            // bottomTab.getMenu().add(Menu.NONE, xx+1, xx+1, x.property("tabName").toString());
            // bottomTab.getMenu().add(x.property("tabName").toString());

        }

    }

}