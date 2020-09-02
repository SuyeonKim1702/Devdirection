package com.softsquared.template.src.main;

import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Toast;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

import java.io.File;
import java.util.List;

public class ReportActivity extends BaseActivity implements MainActivityView {

    private DownloadManager mDownloadManager; //다운로드 매니저.
    private int mDownloadQueueId; //다운로드 큐 아이디..
    private String mFileName ; //파일다운로드 완료후...파일을 열기 위해 저장된 위치를 입력해둔다.
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report1);
        mContext = getApplicationContext();

    }




    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }

    public void reportOnClick(View view) {
        switch (view.getId()) {
            case R.id.bt_test:
              // download("https://d2eip9sf3oo6c2.cloudfront.net/series/square_covers/000/000/036/thumb/EGH_Flexbox.png");

        }
    }
}
