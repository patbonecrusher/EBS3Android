package com.example.pat.ebs3_android.ebclasses;

//import com.eclipsesource.v8.V8;
//import com.eclipsesource.v8.V8Object;

import org.liquidplayer.javascript.JSContext;
import org.liquidplayer.javascript.JSObject;

//public class EBConsole {
//    public void log(final String message) {
//        System.out.println("[INFO] " + message);
//    }
//    public void error(final String message) {
//        System.out.println("[ERROR] " + message);
//    }
//
//    public V8Object constructV8Object(V8 runtime) {
//        V8Object v8Generator = new V8Object(runtime);
//
//        v8Generator.registerJavaMethod(this, "log", "log", new Class<?>[] { String.class });
//        v8Generator.registerJavaMethod(this, "error", "err", new Class<?>[] { String.class });
//
//        return v8Generator;
//    }
//}

public class EBConsole extends JSObject {
    public EBConsole(JSContext ctx) { super(ctx); }

    @jsexport(type = Integer.class)
    Property<Integer> x;

    @jsexport(type = String.class)
    Property<String>  y;

    @jsexport(attributes = JSPropertyAttributeReadOnly)
    Property<String> read_only;

    @SuppressWarnings("unused")
    @jsexport(attributes = JSPropertyAttributeReadOnly | JSPropertyAttributeDontDelete)
    void log(String message) {
        System.out.println(">>>> " + message);
    }

    @SuppressWarnings("unused")
    @jsexport(attributes = JSPropertyAttributeReadOnly | JSPropertyAttributeDontDelete)
    void error(String message) {
        System.out.println("error: >>>> " + message);
    }
}