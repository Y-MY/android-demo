package com.example.demo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.six.FilePersistenceActivity;
import com.example.demo.six.LitePalActivity;
import com.example.demo.six.SQLiteActivity;
import com.example.demo.six.SharedPreferenceActivity;

public class SixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button buttonFilePersistence = (Button) findViewById(R.id.file_persistence_button);
        buttonFilePersistence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SixActivity.this, FilePersistenceActivity.class);
                startActivity(intent);
            }
        });

        Button buttonSharedPersistence = (Button) findViewById(R.id.shared_persistence_button);
        buttonSharedPersistence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SixActivity.this, SharedPreferenceActivity.class);
                startActivity(intent);
            }
        });

        Button buttonSqlLite = (Button) findViewById(R.id.sqlite_button);
        buttonSqlLite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SixActivity.this, SQLiteActivity.class);
                startActivity(intent);
            }
        });

        Button buttonLitePal = (Button) findViewById(R.id.litepal_button);
        buttonLitePal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(FirstActivity.this,"YOU CLICK button2 ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SixActivity.this, LitePalActivity.class);
                startActivity(intent);
            }
        });
    }
}