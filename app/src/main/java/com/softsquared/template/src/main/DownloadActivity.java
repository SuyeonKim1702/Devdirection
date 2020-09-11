
package com.softsquared.template.src.main;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.core.content.FileProvider;

import com.softsquared.template.R;
import com.softsquared.template.src.BaseActivity;
import com.softsquared.template.src.main.interfaces.MainActivityView;

import java.io.File;
import java.time.Month;

@SuppressWarnings("SameParameterValue")
public class DownloadActivity extends BaseActivity implements MainActivityView {

    ImageView checkEmail,checkPdf, checkCsv, checkExcel, checkDownload, checkShare;
    private static Handler mHandler;

    int value = 0;
    DownloadManager downloadManager;
    String[] addr = new String[3];
    String[] name = new String[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        checkEmail = findViewById(R.id.check_email);
        checkPdf = findViewById(R.id.check_pdf_fill);
        checkCsv = findViewById(R.id.check_csv_fill);
        checkExcel = findViewById(R.id.check_excel_fill);
        checkDownload = findViewById(R.id.check_download);
        checkShare = findViewById(R.id.check_share);
        addr[0]="https://drive.google.com/u/1/uc?id=1WthCXoVNBWAhhKnQAL_U-Vj722JAWfhp&export=download";
        addr[1]="https://drive.google.com/u/1/uc?id=127aKhAo7m23t8vpWI1qQ-EDdHsZM-keC&export=download";
        addr[2]="https://drive.google.com/u/1/uc?id=1lNe_uBc7nwZoNj9HIfaw03KQ1zebjhVT&export=download";
        name[0]=".pdf";
        name[1]=".csv";
        name[2]=".xlsx";
    }

    public void downloadOnClick(View view) {
        switch (view.getId()) {

            case R.id.goBack:
                checkPdf.setVisibility(View.GONE);
                checkCsv.setVisibility(View.GONE);
                checkExcel.setVisibility(View.GONE);
                finish();
            case R.id.pdf:
                checkPdf.setVisibility(View.VISIBLE);
                checkCsv.setVisibility(View.GONE);
                checkExcel.setVisibility(View.GONE);
                value = 0;

                break;
            case R.id.csv:
                checkPdf.setVisibility(View.GONE);
                checkCsv.setVisibility(View.VISIBLE);
                checkExcel.setVisibility(View.GONE);
                value = 1;
                break;
            case R.id.excel:
                checkPdf.setVisibility(View.GONE);
                checkCsv.setVisibility(View.GONE);
                checkExcel.setVisibility(View.VISIBLE);
                value = 2;
                break;
            case R.id.bt_download:
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                File file = new File(getExternalFilesDir(null), "devrection_report"+name[value]);
                Uri uri = Uri.parse(addr[value]);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationUri(Uri.fromFile(file));
                Long reference = downloadManager.enqueue(request);

                Log.d("f", "path : " + file.getPath());

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("plain/text");
                checkDownload.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_email:
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                 File file2 = new File(getExternalFilesDir(null), "devrection_report"+name[value]);
                Uri uri2 = Uri.parse(addr[value]);
                DownloadManager.Request request2 = new DownloadManager.Request(uri2);
                request2.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request2.setDestinationUri(Uri.fromFile(file2));
                Long reference2 = downloadManager.enqueue(request2);

                Log.d("f", "path : " + file2.getPath());

                Intent intent2 = new Intent(Intent.ACTION_SEND);

                intent2.setType("plain/text");


                String[] address = {""}; //주소를 넣어두면 미리 주소가 들어가 있다.

                intent2.putExtra(Intent.EXTRA_EMAIL, address);

                //intent.putExtra(Intent.EXTRA_SUBJECT, "제목");

                intent2.putExtra(Intent.EXTRA_TEXT, "devrection에서 전송한 분석 레포트입니다.");
                Uri uri3 = FileProvider.getUriForFile(getBaseContext(), "com.softsquared.template.fileprovider", file2);
                intent2.putExtra(Intent.EXTRA_STREAM, uri3); //파일 첨부
                checkEmail.setVisibility(View.VISIBLE);
                startActivity(intent2);
                checkEmail.setVisibility(View.VISIBLE);
                break;

            case R.id.bt_share:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                File file3 = new File(getExternalFilesDir(null), "devrection_report"+name[value]);
                Uri uri4 = Uri.parse(addr[value]);
                DownloadManager.Request request3 = new DownloadManager.Request(uri4);
                request3.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request3.setDestinationUri(Uri.fromFile(file3));
                //Long reference3 = downloadManager.enqueue(request3);

                Log.d("f", "path : " + file3.getPath());
                Uri uri5 = FileProvider.getUriForFile(getBaseContext(), "com.softsquared.template.fileprovider", file3);	// android image path
                sharingIntent.setType("plain/text");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, uri5);
                startActivity(Intent.createChooser(sharingIntent, "devrection의 분석 리포트 전송")); // 변경가능
                checkShare.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void validateSuccess(String text) {

    }

    @Override
    public void validateFailure(String message) {

    }
}
