package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.three.ChatActivity;
import com.example.demo.three.LinearLayoutActivity;
import com.example.demo.three.ListviewActivity;
import com.example.demo.three.RecyclerViewActivity;
import com.example.demo.three.RelativeLayoutActivity;
import com.example.demo.three.UIWidgetActivity;

public class ChapterThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button buttonUIWidget = (Button) findViewById(R.id.button_ui_widget);
        buttonUIWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChapterThreeActivity.this, UIWidgetActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUILinear = (Button) findViewById(R.id.button_ui_linear);
        buttonUILinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChapterThreeActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button buttonUIRelative = (Button) findViewById(R.id.button_ui_relative);
        buttonUIRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChapterThreeActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button buttonListView = (Button) findViewById(R.id.button_list_view);
        buttonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChapterThreeActivity.this, ListviewActivity.class);
                startActivity(intent);
            }
        });

        Button buttonRecycler = (Button) findViewById(R.id.button_recycler_view);
        buttonRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChapterThreeActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        Button buttonChat = (Button) findViewById(R.id.chat);
        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChapterThreeActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

    }
}
