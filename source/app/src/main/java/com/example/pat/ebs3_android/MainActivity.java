package com.example.pat.ebs3_android;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.pat.ebs3_android.ebclasses.EBConsole;
import com.example.pat.ebs3_android.ebclasses.EBUIBuilder;

import org.liquidplayer.javascript.JSContext;
import org.liquidplayer.javascript.JSValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ConstraintLayout cl = new ConstraintLayout(this);
        cl.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));

        RelativeLayout rl = new RelativeLayout(this);
        rl.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));

        final TabLayout tl = new TabLayout(this);
        tl.setId(View.generateViewId());

        RelativeLayout.LayoutParams ptl = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        ptl.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        tl.setLayoutParams(ptl);
        rl.addView(tl);

        final ViewPager vp = new ViewPager(this);
        vp.setId(View.generateViewId());
        vp.setBackgroundColor(Color.BLUE);

        RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ABOVE, tl.getId());
        vp.setLayoutParams(params);

        rl.addView(vp);

        cl.addView(rl);

        final EBPagerAdapter adapter = new EBPagerAdapter(getSupportFragmentManager(), this);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl));
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        String dbScript = readJSFile("EBDatabase.js");
        String mainScript = readJSFile("JSUserInterface.js");

        JSContext context = new JSContext();

        EBConsole console = new EBConsole(context);
        // EBUIBuilder builder = new EBUIBuilder((TabLayout) findViewById(R.id.tabs), (BottomNavigationView) findViewById(R.id.btabs), context);
        EBUIBuilder builder = new EBUIBuilder(tl, adapter, context);
        context.property("console", console);
        context.property("EBUIBuilder", builder);
        context.evaluateScript(mainScript, "http://foo", 0);
        context.evaluateScript(dbScript, "http://foo", 0);

        JSValue buildUIFunction = context.property("buildUI");
        buildUIFunction.toObject().toFunction().call(null, null);

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



        this.setContentView(cl);
    }

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


    private String readJSFile(String fileName) {
        String jsContent = "";
        try {
            jsContent = MainActivity.readFromAssets(getApplicationContext(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsContent;
    }
}
