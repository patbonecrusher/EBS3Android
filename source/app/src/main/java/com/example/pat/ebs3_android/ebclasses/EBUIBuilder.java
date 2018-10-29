package com.example.pat.ebs3_android.ebclasses;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.widget.TextView;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;

public class EBUIBuilder {
    private ConstraintLayout view;
    private Context context;
    public EBUIBuilder(ConstraintLayout view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void drawLabel(Integer x, Integer  y, Integer  height, Integer  width, String label) {
        System.out.printf("x: %d, y: %d, height: %d, width: %d, label: %s\n", x, y, height, width, label);

        TextView ProgrammaticallyTextView = new TextView(this.context);
        ProgrammaticallyTextView.setText(label);
        ProgrammaticallyTextView.setTextSize(22);
        ProgrammaticallyTextView.setPadding(x, y, width, height);
        view.addView(ProgrammaticallyTextView);
    }

    public void buildUI() {

    }

    public V8Object constructV8Object(V8 runtime) {
        V8Object v8Generator = new V8Object(runtime);

        // runtime.add("console", v8Console);
        v8Generator.registerJavaMethod(this, "drawLabel", "drawLabel", new Class<?>[] {
                Integer.class,
                Integer.class,
                Integer.class,
                Integer.class,
                String.class,
        });

        return v8Generator;
    }
}

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
