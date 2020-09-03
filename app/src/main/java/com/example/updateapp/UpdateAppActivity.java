package com.example.updateapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaosimple.MainActivity;
import com.example.greendaosimple.R;

public class UpdateAppActivity extends AppCompatActivity {

    private AppDownloadManager mDownloadManager;
    private String download_url = "http://test-1251233192.coscd.myqcloud.com/1_1.apk";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_app_layout);

        mDownloadManager = new AppDownloadManager(this);


        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUpdateDialog();
            }
        });
    }


    private void showUpdateDialog() {
        final CommonDialog dialog = new CommonDialog(UpdateAppActivity.this);
        dialog.setMessage("app name。")
                .setImageResId(R.mipmap.ic_launcher)
                .setTitle("版本更新")
                .setNegtive("更新")
                .setSingle(true).setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
            @Override
            public void onPositiveClick() {

                String title = "app name";
                String desc = "版本更新";
//
                mDownloadManager.setUpdateListener(new AppDownloadManager.OnUpdateListener() {
                    @Override
                    public void update(int currentByte, int totalByte) {
                        Log.e("UpdateAppActivity", "update--------"+currentByte+"======="+totalByte);
                        dialog.setProgress(currentByte, totalByte);
                        if ((currentByte == totalByte) && totalByte != 0) {
                            dialog.dismiss();
                        }

                    }
                });

                mDownloadManager.downloadApk(download_url, title, desc);

            }

            @Override
            public void onNegtiveClick() {
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mDownloadManager != null) {
            mDownloadManager.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mDownloadManager != null) {
            mDownloadManager.onPause();
        }

    }

//    private void showUpdateDialog(final AppUpdateInfo updateInfo) {
//        AppUpdateDialog dialog = new AppUpdateDialog(getContext());
//        dialog.setAppUpdateInfo(updateInfo);
//        dialog.setOnUpdateClickListener(new AppUpdateDialog.OnUpdateClickListener() {
//            @Override
//            public void update(final AppUpdateDialog updateDialog) {
//                String title = "app name";
//                String desc = "版本更新";
//
//                mDownloadManager.setUpdateListener(new AppDownloadManager.OnUpdateListener() {
//                    @Override
//                    public void update(int currentByte, int totalByte) {
//                        updateDialog.setProgress(currentByte, totalByte);
//                        if ((currentByte == totalByte) && totalByte != 0) {
//                            updateDialog.dismiss();
//                        }
//
//                    }
//                });
//
//                mDownloadManager.downloadApk(updateInfo.download_url, title, desc);
//            }
//
//        });
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setCancelable(false);
//        dialog.show();
//
//    }
}
