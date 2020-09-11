
package com.softsquared.template.src.main;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;
import java.util.ArrayList;

@SuppressWarnings("SameParameterValue")
public class ReportActivity extends BaseActivity implements MainActivityView {

    ImageView goResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_complete_1);

        goResult = findViewById(R.id.iv_result);


    }


    public void reportOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_result:
                Intent intent = new Intent(ReportActivity.this, ReportResultActivity.class);
                startActivity(intent);
                finish();
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
