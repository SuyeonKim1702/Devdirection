package com.softsquared.template.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.common.view.SimpleMessageDialog;
import com.softsquared.template.src.common.view.TwoChoiceDialog;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class WelcomeActivity extends BaseActivity implements MainActivityView {

    ImageView welcomeAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeAnim = findViewById(R.id.iv_welcome_anim);
        Glide.with(this).load(R.raw.search).into(welcomeAnim);
    }

    private void tryGetTest() {

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

    public void customOnClick(View view) {

        switch (view.getId()) {
            case R.id.iv_ok_welcome:
                Intent intent = new Intent(WelcomeActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.main_activity_btn_api_test:
                tryGetTest();
                break;
            case R.id.main_activity_btn_simple_message_dialog:
                SimpleMessageDialog simpleMessageDialog = new SimpleMessageDialog.Builder(this)
                        .setMessage("message")
                        .setButtonText("ok")
                        .setOnClickListener(dialog -> {
                            showCustomToast("click");
                            dialog.dismiss();
                        })
                        .build();
                simpleMessageDialog.show();
                break;

            case R.id.main_activity_btn_two_choice_dialog:
                TwoChoiceDialog twoChoiceDialog = new TwoChoiceDialog.Builder(this)
                        .setMessage("message")
                        .setOnClickListener((dialog, which) -> {
                            dialog.dismiss();
                            switch (which) {
                                case TwoChoiceDialog.BUTTON_LEFT:
                                    showCustomToast("left");
                                    break;
                                case TwoChoiceDialog.BUTTON_RIGHT:
                                    showCustomToast("right");
                                    break;
                            }
                        }).build();
                twoChoiceDialog.setCancelable(false);
                twoChoiceDialog.show();
                break;
            default:
                break;
        }
    }
}
