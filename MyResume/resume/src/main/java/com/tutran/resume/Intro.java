package com.tutran.resume;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

import com.tutran.resume.MyResumeActivity;
import com.tutran.resume.R;


/**
 * Created by suncowiam on 3/2/14.
 */
public class Intro extends Activity {
    final static public boolean DEBUG = MyResumeActivity.DEBUG;
    final static private String LOG = "MyResumeActivity";
    static public void LOGD(String log) {
        if (DEBUG) Log.d(LOG, log);
    }

    private CountDownTimer mTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTimer = new CountDownTimer(15000, 1000) {
            public void onTick(long ms) {
                LOGD("intro end: " + ms);
            }
            public void onFinish() {
                finish();
            }
        }.start();

        setContentView(R.layout.intro);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void onIntroClicked(View v) {
        mTimer.cancel();
        finish();
    }
}
