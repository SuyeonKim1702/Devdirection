
package com.softsquared.template.src.main;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

@SuppressWarnings("SameParameterValue")
public class MonthActivity extends BaseActivity implements MainActivityView {

    ImageView goResult;
    LinearLayout llDates;
    ImageView  month2, month3;
    TextView march,month1;
    int name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        llDates = findViewById(R.id.ll_dates);
        month1 = findViewById(R.id.month_1);
        month2 = findViewById(R.id.month_2);
        month3 = findViewById(R.id.month_3);
        goResult = findViewById(R.id.iv_result);
        march = findViewById(R.id.march);
        month1.setText(Html.fromHtml("<b>3월</b>"+"에는 총 "+"<b>2개</b>"+"의<br>분석결과 리포트가 있습니다."));
        Intent intent = getIntent();
        name = intent.getIntExtra("who",5);

    }


    public void monthOnClick(View view) {
        switch (view.getId()) {
            case R.id.go_to_previous_month:
                finish();
                break;
            case R.id.march:
                march.setBackgroundResource(R.drawable.bg_arc_yellow);
                march.setTextColor(Color.rgb(255,255,255));
                llDates.setVisibility(View.VISIBLE);
                month1.setVisibility(View.VISIBLE);
                month2.setVisibility(View.VISIBLE);
                month3.setVisibility(View.VISIBLE);
                break;
            case R.id.month_2:
            case R.id.month_3:
                if(name == 0){
                    Intent intent = new Intent(MonthActivity.this, ReportResultActivity.class);
                    startActivity(intent);

                    break;

                }else if(name == 1){
                    Intent intent = new Intent(MonthActivity.this, ReportResult2Activity.class);
                    startActivity(intent);

                    break;
                }
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
