package com.example.pat.ebs3_android;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.example.pat.ebs3_android.ebclasses.EBConsole;
import com.example.pat.ebs3_android.ebclasses.EBUIBuilder;

import org.liquidplayer.javascript.JSContext;
import org.liquidplayer.javascript.JSValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    final V8 runtime = V8.createV8Runtime();

    public static String readFromAssets(Context context, String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));

        // do reading, usually loop until end of file reading
        StringBuilder sb = new StringBuilder();
        String mLine = reader.readLine();
        while (mLine != null) {
            sb.append(mLine); // process line
            mLine = reader.readLine();
        }
        reader.close();
        return sb.toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.loadEBClassesIntoV8Context();
        runtime.executeScript("console.log('>>>>>>>>>>>>>>> hello, world');");

//        String databaseScript = readJSFile("EBDatabase.js");
//        runtime.executeScript(databaseScript);

//        String mainScript = readJSFile("JSUserInterface.js");
//        runtime.executeScript(mainScript);


        JSContext context = new JSContext();
        context.property("a", 5);
        JSValue aValue = context.property("a");
        double a = aValue.toNumber();
        DecimalFormat df = new DecimalFormat(".#");
        System.out.println(df.format(a)); // 5.0
        context.evaluateScript("a = 10");
        JSValue newAValue = context.property("a");
        System.out.println(df.format(newAValue.toNumber())); // 10.0
        String script =
                "function factorial(x) { var f = 1; for(; x > 1; x--) f *= x; return f; }\n" +
                        "var fact_a = factorial(a);\n";
        context.evaluateScript(script);
        JSValue fact_a = context.property("fact_a");
        System.out.println(df.format(fact_a.toNumber())); // 3628800.0
    }

    private String readJSFile(String fileName) {
        String jsContent = "";
        try {
            jsContent = MainActivity.readFromAssets(getApplicationContext(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsContent;
    }

    private void loadEBClassesIntoV8Context() {
        final EBConsole console = new EBConsole();
        final V8Object v8Console = console.constructV8Object(runtime);
        runtime.add("console", v8Console);

        final EBUIBuilder uiBuilder = new EBUIBuilder((ConstraintLayout) findViewById(R.id.scl), getApplicationContext());
        final V8Object v8UIBuilder = uiBuilder.constructV8Object(runtime);
        runtime.add("EBUIBuilder", v8UIBuilder);
    }


}
