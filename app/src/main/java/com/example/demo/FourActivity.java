package com.example.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.demo.four.DynamicFragmentActivity;
import com.example.demo.four.NewsActivity;
import com.example.demo.four.SimpleFragmentActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class FourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button buttonFragmentSimple = (Button) findViewById(R.id.simple_fragment);
        buttonFragmentSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FourActivity.this, SimpleFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button buttonFragmentDynamic = (Button) findViewById(R.id.dynamic_fragment);
        buttonFragmentDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FourActivity.this, DynamicFragmentActivity.class);
                startActivity(intent);
            }
        });

        Button buttonFragmentNews = (Button) findViewById(R.id.news_fragment);
        buttonFragmentNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FourActivity.this, NewsActivity.class);
                startActivity(intent);
            }
        });


    }

  /*  @OnClick(R.id.simple_fragment)
    public void goToFragment(){
        ARouter.getInstance().build(Rounter.ACTIVITY4_SIMPLE_FRAGMENT)
                .navigation();
    }*/
}