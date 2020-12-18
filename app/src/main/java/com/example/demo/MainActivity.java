package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button buttonChapterThree = (Button) findViewById(R.id.chapter_three);
        buttonChapterThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ChapterThreeActivity.class);
                startActivity(intent);
            }
        });

        Button buttonChapterFour = (Button) findViewById(R.id.chapter_four);
        buttonChapterFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FourActivity.class);
                startActivity(intent);
            }
        });

        Button buttonChapterFive = (Button) findViewById(R.id.chapter_five);
        buttonChapterFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FiveActivity.class);
                startActivity(intent);
            }
        });

        Button buttonChapterSix = (Button) findViewById(R.id.chapter_six);
        buttonChapterSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SixActivity.class);
                startActivity(intent);
            }
        });

     /*   Button button = (Button) findViewById(R.id.third_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                Process.killProcess(Process.myPid());
            }
        });*/
    }


}
