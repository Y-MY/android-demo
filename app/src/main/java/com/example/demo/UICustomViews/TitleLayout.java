package com.example.demo.UICustomViews;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.demo.R;

import androidx.annotation.Nullable;

public class TitleLayout extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "TitleLayout";

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.activity3_title, this);

        Button titleBack = (Button) findViewById(R.id.title_back);
        Button titleEdit = (Button) findViewById(R.id.title_edit);

        Log.i(TAG, "TitleLayout: "+attrs);

        titleBack.setOnClickListener(this);
        titleEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_back:
                ((Activity) getContext()).finish();
                break;
            case R.id.title_edit:
                Toast.makeText(getContext(), "you click edit button", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
