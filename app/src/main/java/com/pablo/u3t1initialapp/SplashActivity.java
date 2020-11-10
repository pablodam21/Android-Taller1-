package com.pablo.u3t1initialapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

public class SplashActivity extends AppCompatActivity {
    private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                    sound = MediaPlayer.create(getApplicationContext(), R.raw.par);
                    sound.start();
                    sleep(5000);
                }catch (InterruptedException e){
                    System.out.println("algo malo paso");
                }finally {
                    startActivity(new Intent("com.pablo.u3t1initialapp.STARTINGPOINT"));
                }
            }
        };

        timer.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.release();
        sound = null;
        finish();
    }


}