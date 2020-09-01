package com.softsquared.template.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.common.view.SimpleMessageDialog;
import com.softsquared.template.src.common.view.TwoChoiceDialog;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class LogInActivity extends BaseActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    public void customOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_connect_logIn:
                Intent intent = new Intent(LogInActivity.this, ConsentActivity.class);
                startActivity(intent);
                finish();
                break;

        }
    }
}
