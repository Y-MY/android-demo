package com.example.demo.five;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.demo.FiveActivity;
import com.example.demo.R;

public class LocalBroadcastActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private LocalReciver localReciver;

    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_local_broadcast);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        //获取实例
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        Button buttonBroadcastSend = (Button) findViewById(R.id.sendButton);
        buttonBroadcastSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.demo.LOCAL_BROADCAST");
                //发送本地广播
               localBroadcastManager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.demo.LOCAL_BROADCAST");
        localReciver = new LocalReciver();
        //注册本地广播监听器
        localBroadcastManager.registerReceiver(localReciver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localReciver);
    }

    class LocalReciver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "reveived local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}