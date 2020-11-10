package com.pablo.u3t1initialapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int count;

    private TextView tvDisplay;

    private Button buttonIncrease, buttonDecrease, buttonReset, buttonTwoIncrease, buttonTwoDecrease;

    private static final String KEY_TEXT_VALUE = "textValue";


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
        buttonTwoIncrease = findViewById(R.id.buttonIncrease2Elements);
        buttonTwoDecrease = findViewById(R.id.buttonDecrease2Elements);
        buttonReset = findViewById(R.id.buttonReset);


        // set onclicklistener
        buttonIncrease.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonTwoIncrease.setOnClickListener(this);
        buttonTwoDecrease.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonIncrease: count ++;break;
            case R.id.buttonDecrease: count --;break;
            case R.id.buttonIncrease2Elements: count = count+2;break;
            case R.id.buttonDecrease2Elements: count = count-2;break;
            case R.id.buttonReset:count = 0;break;
        }
        tvDisplay.setText(getString(R.string.number_of_elements) + ":" + count);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        tvDisplay.setText(savedInstanceState.getString(KEY_TEXT_VALUE));

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(KEY_TEXT_VALUE,tvDisplay.getText().toString());
        super.onSaveInstanceState(outState);

    }


}