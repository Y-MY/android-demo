package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.five.BroadcastActivity;
import com.example.demo.five.LocalBroadcastActivity;
import com.example.demo.four.SimpleFragmentActivity;

public class FiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button buttonBroadcastDynamic = (Button) findViewById(R.id.broadcast_dynamic);
        buttonBroadcastDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FiveActivity.this, BroadcastActivity.class);
                startActivity(intent);
            }
        });

        Button buttonBroadcastSendStand = (Button) findViewById(R.id.broadcast_send_stand);
        buttonBroadcastSendStand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.demo.MY_BROADCAST");
                // 发送标准广播，发出的广播可以被其他的应用程序接收到
                // sendBroadcast(intent);
                // 发送有序广播
                sendOrderedBroadcast(intent,null);
            }
        });
        Button buttonBroadcastLocal = (Button) findViewById(R.id.broadcast_local);
        buttonBroadcastLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FiveActivity.this, LocalBroadcastActivity.class);
                startActivity(intent);
            }
        });



    }
}