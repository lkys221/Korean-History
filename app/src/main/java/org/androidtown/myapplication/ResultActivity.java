package org.androidtown.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ResultActivity extends AppCompatActivity {
    RingProgressBar ringProgressBar;
    int score;
    TextView textView;

    SharedPreferences choicePref, resultPref, comparePref;
    SharedPreferences.Editor choiceEditor, resultEditor, compareEditor;



    Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0)
                ringProgressBar.setProgress(score);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        choicePref = getSharedPreferences("Choices", Context.MODE_PRIVATE);
        choiceEditor = choicePref.edit();

        resultPref = getSharedPreferences("Results", Context.MODE_PRIVATE);
        resultEditor = resultPref.edit();

        comparePref = getSharedPreferences("Compares", Context.MODE_PRIVATE);
        compareEditor = comparePref.edit();

        score = resultPref.getInt("go_39", 0);
        textView = (TextView) findViewById(R.id.textview1);



        ringProgressBar = (RingProgressBar) findViewById(R.id.progressbar);
        ringProgressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {
            @Override
            public void progressToComplete() {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    myHandler.sendEmptyMessage(0);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();

        textView.setText(score + " / 15");


    }
}
