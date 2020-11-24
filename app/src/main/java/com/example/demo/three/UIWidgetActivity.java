package com.example.demo.three;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.demo.R;

public class UIWidgetActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;

    private static final String TAG = "UIWidgetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_uiwidget);

        editText = (EditText) findViewById(R.id.ui_widget_editText);
        imageView = (ImageView) findViewById(R.id.ui_widget_imageView);
        progressBar = (ProgressBar) findViewById(R.id.ui_widget_process_bar);

        Button button = (Button) findViewById(R.id.ui_widget_button);
        Button button2 = (Button) findViewById(R.id.ui_widget_button2);
        Button button3 = (Button) findViewById(R.id.ui_widget_button3);
        Button button4 = (Button) findViewById(R.id.ui_widget_button4);
        Button button5 = (Button) findViewById(R.id.ui_widget_button5);
        Button button6 = (Button) findViewById(R.id.ui_widget_button6);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ui_widget_button:
                String inputText = editText.getText().toString();
                Toast.makeText(UIWidgetActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.ui_widget_button2:
                imageView.setImageResource(R.drawable.image2);
                break;
            case R.id.ui_widget_button3:
                if (progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.ui_widget_button4:
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                break;
            case R.id.ui_widget_button5:
                AlertDialog.Builder dialog = new AlertDialog.Builder(UIWidgetActivity.this);
                dialog.setTitle("THIS IS DIALOG");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick:OK ");
                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.i(TAG, "onClick: cancel");
                    }
                });
                dialog.show();
                break;
            case R.id.ui_widget_button6:
                ProgressDialog progressDialog = new ProgressDialog(UIWidgetActivity.this);
                progressDialog.setTitle("THIS IS ProgressDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }

    }
}
