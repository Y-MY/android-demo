package com.example.demo.four;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4_dynamic_fragment);

        Button buttonFragmentAdd = (Button) findViewById(R.id.add_fragment_button);
        buttonFragmentAdd.setOnClickListener(this);
        replaceFragment(new RightFragment());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_fragment_button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}