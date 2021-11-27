package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


public class Splashscreen extends AppCompatActivity {

    ImageView imageView;
    TextView nameTv,name2tv;
    MediaPlayer mysong;

    long animTime= 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashscreen);
        mysong=MediaPlayer.create(Splashscreen.this,R.raw.song);
        mysong.start();

        imageView=findViewById(R.id.iv_logo_splash);
        nameTv=findViewById(R.id.tv_splash_name);
        name2tv=findViewById(R.id.tv_splash_name2);

        ObjectAnimator animatorY= ObjectAnimator.ofFloat(imageView,"y",600f);
       //ObjectAnimator animatorname= ObjectAnimator.ofFloat(imageView,"x",200f);
        animatorY.setDuration(animTime);
       // animatorname.setDuration(animTime);
        AnimatorSet animatorSet= new AnimatorSet();
        animatorSet.playTogether(animatorY);
        animatorSet.start();

        ObjectAnimator animatorText= ObjectAnimator.ofFloat(nameTv,"x",300f);
        ObjectAnimator animatorname1= ObjectAnimator.ofFloat(name2tv,"x",400f);
        animatorText.setDuration(animTime);
       animatorname1.setDuration(animTime);
        AnimatorSet animatorSet1= new AnimatorSet();
        animatorSet1.playTogether(animatorText,animatorname1);
        animatorSet1.start();

        Handler handler= new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Splashscreen.this, MainActivity_note.class);
                startActivity(intent);
                mysong.release();
                finish();

            }
        },3000);



    }
}