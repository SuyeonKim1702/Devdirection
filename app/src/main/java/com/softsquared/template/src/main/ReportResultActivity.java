
package com.softsquared.template.src.main;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;


public class ReportResultActivity extends BaseActivity implements MainActivityView {

    ImageView gif;
    private static Handler mHandler;
    NewRunnable nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_1);




    }
    class NewRunnable implements Runnable {

        @Override
        public void run() {

            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            mHandler.sendEmptyMessage(1);


        }

    }


    public void reportResultOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_download_minsoo:
                Intent intent = new Intent(ReportResultActivity.this, DownloadActivity.class);
                startActivity(intent);
                break;
            case R.id.go_to_recommend_minsoo:
                Intent intent2 = new Intent(ReportResultActivity.this, ReportRecommendActivity.class);
                intent2.putExtra("who",0);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
