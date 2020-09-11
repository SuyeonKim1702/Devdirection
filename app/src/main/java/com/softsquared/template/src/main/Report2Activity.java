
package com.softsquared.template.src.main;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

@SuppressWarnings("SameParameterValue")
public class Report2Activity extends BaseActivity implements MainActivityView {

    ImageView goResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_complete_2);

        goResult = findViewById(R.id.iv_result_2);


    }


    public void reportOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_result_2:
                Intent intent = new Intent(Report2Activity.this, ReportResult2Activity.class);
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
