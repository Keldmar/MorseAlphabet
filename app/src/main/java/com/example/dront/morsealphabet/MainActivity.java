package com.example.dront.morsealphabet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.os.Handler;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textViev;
    private Handler handler;
    private RelativeLayout vie;
    private static final int INTERVAL_BETWEEN_TRIGGERS = 5000;
    private static HashMap<String, Boolean[]> azbuka = new HashMap<>();

    static {
        azbuka.put("A", new Boolean[]{false, true});
        azbuka.put("S", new Boolean[]{false, false, false});
        azbuka.put("O", new Boolean[]{true, true, true});
    }

//    private Runnable triggerRunnable = new Runnable() {
//        @Override
//        public void run() {
//            try {
//                translate("SOS");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            handler.postDelayed(triggerRunnable, INTERVAL_BETWEEN_TRIGGERS);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textViev = (TextView) findViewById(R.id.textView);
        vie = (RelativeLayout) findViewById(R.id.myLayout);
//        handler = new Handler();
//        handler.post(triggerRunnable);
    }

    private void translate(String s) throws Exception {
        char letter;
        String outputString;
        for (int i = 0; i < s.length(); i++) {
            letter = s.charAt(i);
            outputString = new String(String.valueOf(letter));
            Boolean[] array = azbuka.get(outputString);
            for (int j = 0; j < array.length; j++) {
                if (array[j] == true) {
                    setValue(true);
                    Thread.sleep(10000);
                    setValue(false);
                    Thread.sleep(2000);
                } else {
                    setValue(true);
                    Thread.sleep(2000);
                    setValue(false);
                    Thread.sleep(2000);
                }
            }
            Thread.sleep(10000);
        }
    }

    private void setValue(boolean v) {
        if (v == true) {
            //           vie.setBackgroundResource(R.color.white);
            textViev.setText("heeeeeeeeeeeeeeeeeer");
        } else {
            //           vie.setBackgroundResource(R.color.black);
            textViev.setText("her");
        }
    }

    public void onClick(View view) throws Exception {

//        if (editText.getText().length() == 0) {
//            textViev.setText("Hello Kitty!");
//        } else {
        for (int i = 0; i < 10; i++) {
            textViev.setText(i);
            Thread.sleep(5000);
        }
    }
}
