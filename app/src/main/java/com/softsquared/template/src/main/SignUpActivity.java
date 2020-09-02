package com.softsquared.template.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.common.view.SimpleMessageDialog;
import com.softsquared.template.src.common.view.TwoChoiceDialog;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class SignUpActivity extends BaseActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    private void tryGetTest() {
        showProgressDialog();

        final WelcomeService welcomeService = new WelcomeService(this);
        welcomeService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        showCustomToast(text);
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void signUpOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_complete_sign_up:
                Intent intent = new Intent(SignUpActivity.this, ReportActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
