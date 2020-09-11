
package com.softsquared.template.src.main;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;


public class ReportRecommendActivity extends BaseActivity implements MainActivityView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_minsoo);


    }



    public void recommendResultOnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_go_to_back_p_minsoo:
                Intent intent2 = new Intent(ReportRecommendActivity.this, MonthActivity.class);
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
