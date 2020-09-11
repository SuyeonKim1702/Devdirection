
package com.softsquared.template.src.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;


public class ReportRecommend2Activity extends BaseActivity implements MainActivityView {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend_jiyoon);


    }



    public void recommendResult2OnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_go_to_back_p_jiyoon:
                Intent intent2 = new Intent(ReportRecommend2Activity.this, MonthActivity.class);
                intent2.putExtra("who",1);
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
