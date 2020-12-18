package com.example.demo.five;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.example.demo.R;

public class BroadcastActivity extends AppCompatActivity {

    private IntentFilter intentFilter;

    private NetworkChangeReciver networkChangeReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity5_broadcast);

        intentFilter= new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        networkChangeReciver = new NetworkChangeReciver();

        registerReceiver(networkChangeReciver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReciver);
    }

    class NetworkChangeReciver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null && networkInfo.isAvailable()){
                Toast.makeText(context, "newwork is available", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "newwork is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }
}