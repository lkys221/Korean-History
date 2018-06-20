package org.androidtown.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class ResultActivity extends AppCompatActivity {
    RingProgressBar ringProgressBar;
    int score = 10;

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


    }
}
