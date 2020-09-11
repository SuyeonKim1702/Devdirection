
package com.softsquared.template.src.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;


public class ReportResult2Activity extends BaseActivity implements MainActivityView {

    ImageView goResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_2);


    }


    public void reportResult2OnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_download_jiyoon:
                Intent intent = new Intent(ReportResult2Activity.this, DownloadActivity.class);
                startActivity(intent);
                break;
            case R.id.go_to_recommend_jiyoon:
                Intent intent2 = new Intent(ReportResult2Activity.this, ReportRecommend2Activity.class);
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
