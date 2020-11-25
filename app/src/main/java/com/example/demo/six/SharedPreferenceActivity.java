package com.example.demo.six;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;

public class SharedPreferenceActivity extends AppCompatActivity {
    private static final String TAG = "SharedPreferenceActivit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6_shared_preference);

        Button buttonSave = (Button) findViewById(R.id.shared_save_data);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "tom");
                editor.putInt("age", 18);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        Button buttonRestore = (Button) findViewById(R.id.shared_restore_data);
        buttonRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
                String name = pref.getString("name", "");
                int age = pref.getInt("age", 0);
                boolean married = pref.getBoolean("married", false);
                Log.i(TAG, "name is  " + name);
                Log.i(TAG, "age is  " + age);
                Log.i(TAG, "married is  " + married);
            }
        });

    }
}