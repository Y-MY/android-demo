package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button = (Button) findViewById(R.id.first_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                String data = intent.getStringExtra("extra_data");
                Log.v(TAG, data);
                Log.d(TAG, data);
                Log.i(TAG, data);
                Log.w(TAG, data);
                Log.e(TAG, data);
            }
        });

        Button button2 = (Button) findViewById(R.id.first_button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                Log.i(TAG, "点击第二个按钮");
                intent.putExtra("return_data", "Hello MainActivity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("return_data", "Hello MainActivity");
        setResult(RESULT_OK, intent);
        finish();
    }



}
