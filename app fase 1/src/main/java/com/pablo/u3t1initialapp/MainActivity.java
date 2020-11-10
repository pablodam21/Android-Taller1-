package com.pablo.u3t1initialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int count;

    private TextView tvDisplay;

    private Button buttonIncrease, buttonDecrease, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUI();
    }

    private void setUI(){
        //linking Resources
        tvDisplay = findViewById(R.id.tvDisplay);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonReset = findViewById(R.id.buttonReset);

        // set onclicklistener
        buttonIncrease.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonIncrease: count ++;break;
            case R.id.buttonDecrease: count --;break;
            case R.id.buttonReset:count = 0;break;
        }
        tvDisplay.setText(getString(R.string.number_of_elements) + ":" + count);
    }
}