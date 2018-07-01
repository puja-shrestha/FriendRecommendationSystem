package com.example.puza.friendrecommendation;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashLogoActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2500;

    Animation rotateAnimation;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_logo);

        imageView=(ImageView) findViewById(R.id.imageView);
        rotateAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashLogoActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);

    }

    private void rotateAnimation() {

        rotateAnimation= AnimationUtils.loadAnimation(this,R.anim.rotate);
        imageView.startAnimation(rotateAnimation);

    }

}
