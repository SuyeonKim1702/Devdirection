package com.softsquared.template.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class SplashActivity extends BaseActivity implements MainActivityView  {

    ImageView ivSplashAnim;
    private static Handler mHandler;
    NewRunnable nr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivSplashAnim = findViewById(R.id.anim_splash);
        Glide.with(this).load(R.raw.splash).into(ivSplashAnim);
        nr = new NewRunnable(); //타이머 시작
        Thread timeThread = new Thread(nr);
        timeThread.start();

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        } ;
    }

    class NewRunnable implements Runnable {

        @Override
        public void run() {

            try {
                Thread.sleep(4300);
            } catch (Exception e) {
                e.printStackTrace();
            }

            mHandler.sendEmptyMessage(1);


        }

    }



    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
