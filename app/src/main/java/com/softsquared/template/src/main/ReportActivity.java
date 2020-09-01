package com.softsquared.template.src.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

public class ReportActivity extends BaseActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
    }

    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    public void consentOnClick(View view) {
        switch (view.getId()) {


        }
    }
}
