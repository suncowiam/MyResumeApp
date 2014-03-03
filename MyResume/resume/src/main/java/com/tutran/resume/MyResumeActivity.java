package com.tutran.resume;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.tutran.resume.Intro;
import com.tutran.resume.R;

import java.util.ArrayList;

public class MyResumeActivity extends Activity {
    final static public boolean DEBUG = true;
    final static private String LOG = "MyResumeActivity";
    static public void LOGD(String log) {
        if (DEBUG) Log.d(LOG, log);
    }
    final int REQ_CODE_INTRO = 0;

    final String RESUME_MASTER = "Resume";
    final String RESUME_DETAIL = "resume";
    final String SAMPLE_MASTER = "Sample";
    final String SAMPLE_DETAIL = "sample";
    final String CONTACT_MASTER = "Contact";
    final String CONTACT_DETAIL = "contact";
    ArrayList<DetailItem> mDetailItems;

    private boolean mIsTwoPane;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDetailItems();

        // Determine screen size
        mIsTwoPane = false;
        mIsTwoPane = getResources().getBoolean(R.bool.large_display) == true;
        LOGD("large_display: " + mIsTwoPane);

        if (mIsTwoPane) {
            setContentView(R.layout.my_resume_multi_pane);
        } else {
            setContentView(R.layout.my_resume_single_pane);
        }

        Intent intent = new Intent(this, Intro.class);
        startActivityForResult(intent, REQ_CODE_INTRO);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == REQ_CODE_INTRO) {
            // Intro Sequence Ended
        }
    }

    void createDetailItems() {
        mDetailItems = new ArrayList<DetailItem>();
        mDetailItems.add(new DetailItem(RESUME_MASTER, RESUME_DETAIL));
        mDetailItems.add(new DetailItem(SAMPLE_MASTER, SAMPLE_DETAIL));
        mDetailItems.add(new DetailItem(CONTACT_MASTER, CONTACT_DETAIL));
    }

    protected void onRestart() {
        super.onRestart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
     
    protected void onStop() {
        super.onStop();
    }
     
    protected void onDestroy() {
        super.onDestroy();
    }

    public class DetailItem {
        private String mMaster;
        private String mDetail;

        DetailItem(String master, String detail) {
            mMaster = master;
            mDetail = detail;
        }

        public String getMaster() { return mMaster;}
        public String getDetail() { return mDetail;}
    }
}
