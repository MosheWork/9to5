package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class attendance extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attendance);
    }
    public  void enterclock(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

    }
}
//Toast.makeText(attendance.this, "You enter clock", Toast.LENGTH_SHORT).show();