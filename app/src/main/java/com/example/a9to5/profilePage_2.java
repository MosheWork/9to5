package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.Sampler;
import android.widget.TextView;

public class profilePage_2 extends AppCompatActivity {

    TextView textView2;
    String St;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page2);

        textView2=findViewById(R.id.textProfile2);
        St=getIntent().getExtras().getString("Value");
        textView2.setText(St);

    }
}