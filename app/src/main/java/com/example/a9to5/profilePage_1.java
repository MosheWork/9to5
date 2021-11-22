package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class profilePage_1 extends AppCompatActivity {

    Button SubmitBtn1;
    EditText Profile_Name_text;
    String Profile_name_Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page1);

        SubmitBtn1 = findViewById(R.id.SubmitBtn);
        Profile_Name_text= findViewById(R.id.Nametext);

        SubmitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(profilePage_1.this, profilePage_2.class);
                Profile_name_Str=Profile_Name_text.getText().toString();
                i.putExtra("Value",Profile_name_Str);
                startActivity(i);
                finish();
            }
        });
    }
}