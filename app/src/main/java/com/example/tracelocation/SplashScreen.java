package com.example.tracelocation;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import java.util.Objects;

public class SplashScreen extends AppCompatActivity {
    ImageView splashCenterLogo,splashBottomLogo;
    Animation centerAnimation,bottomAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashCenterLogo=findViewById(R.id.splashLogoId);
        splashBottomLogo=findViewById(R.id.splashBottomLogoId);

        Objects.requireNonNull(this.getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        centerAnimation= AnimationUtils.loadAnimation(this,R.anim.center_animation);
        splashCenterLogo.setAnimation(centerAnimation);

        bottomAnimation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        splashBottomLogo.setAnimation(bottomAnimation);

        Thread go=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    startActivity(new Intent(SplashScreen.this,MapActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        go.start();
    }
}