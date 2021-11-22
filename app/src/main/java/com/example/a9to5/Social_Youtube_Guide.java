package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Social_Youtube_Guide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_youtube_guide);

        Intent intent= new Intent(Social_Youtube_Guide.this,LoginActivity.class);
        startActivity(intent);
    }
}