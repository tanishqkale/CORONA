package com.example.coronago;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Hooks
    View appLogo;
    TextView appSlogan,Name;

    //animations
    Animation topAnimation, bottomAnimation, middleAnimation ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        middleAnimation = AnimationUtils.loadAnimation(this,R.anim.middle_animation);

        //Hooks
        appLogo = findViewById(R.id.app_Logo);
        appSlogan = findViewById(R.id.name);
        Name = findViewById(R.id.tagLine);

        appLogo.setAnimation(topAnimation);
        Name.setAnimation(bottomAnimation);
        appSlogan.setAnimation(middleAnimation);

        //splash to main
        int SPLASH_TIME_OUT = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
               finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
