package com.example.android.concurrency;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class DownloadHandler extends Handler {

    private static final String TAG = "MyTag";
    private final MainActivity mActivity;

    public DownloadHandler(MainActivity activity) {
        this.mActivity=activity;
    }

    @Override
    public void handleMessage(Message msg) {

        downloadSong(msg.obj.toString());
    }

    private void downloadSong(final String songName){
        Log.d(TAG, "run: staring download");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActivity.log("Downlaod Complete "+songName);
                mActivity.displayProgressBar(false);
            }
        });



        Log.d(TAG, "downloadSong: "+songName+" Downloaded...");
    }
}
