package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Social_Youtube_Guide extends AppCompatActivity {


FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_youtube_guide);
        auth=FirebaseAuth.getInstance();

    }

    public void logOut(View view) {
        auth.signOut();

    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            Intent intent= new Intent(Social_Youtube_Guide.this ,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    }