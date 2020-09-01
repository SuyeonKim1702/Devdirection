package com.softsquared.template.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class ConsentActivity extends BaseActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consent);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    public void consentOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_agree_consent:
                Intent intent = new Intent(ConsentActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.iv_cancel_consent:
                Intent intent2 = new Intent(ConsentActivity.this, LogInActivity.class);
                startActivity(intent2);
                finish();
                break;

        }
    }
}
