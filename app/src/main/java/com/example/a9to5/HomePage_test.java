package com.example.a9to5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomePage_test extends AppCompatActivity {
    ///////buttons announcement
    private ImageView Clockbtn;
    private Button ProfileBtn;
    private ImageView Paybtn;
    private ImageView SchedlingBtn;
    private  ImageView ReminderBtn;
    private  ImageView imageheartBtn;
    private  ImageView SocialnetworkBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_test);


   ///buttons listeners
        //שעון נוכחות
        Clockbtn =findViewById(R.id.imageClock);
        Clockbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowClockTimes();
            }
        });
        //פרופיל
        ProfileBtn =findViewById(R.id.buttonProfile);
        ProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowProfilePage();
            }
        });
        //חישובי שכר
        Paybtn= findViewById(R.id.pay);
        Paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowSalary();
            }
        });
        //סידור עבודה
        SchedlingBtn = findViewById(R.id.imageSchedling);
        SchedlingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowSchedling();
            }
        });
        //תזכורות
        ReminderBtn = findViewById(R.id.reminder);
        ReminderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowReminders();
            }
        });
        //בריאות
        imageheartBtn = findViewById(R.id.imageheart);
        imageheartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowHealth();
            }
        });
        //חברתי
        SocialnetworkBtn = findViewById(R.id.Socialnetwork);
        SocialnetworkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToShowSocial();
            }
        });

    }




    //מטודה שמעבירה לדף הנבחר

    private void moveToShowClockTimes(){
        Intent intent= new Intent(this , attendance.class);
        startActivity(intent);
    }
    private void moveToShowProfilePage(){
        Intent intent= new Intent(this , ProfilePage.class);
        startActivity(intent);
    }
    private  void  moveToShowSalary(){
        Intent intent= new Intent(this,SalaryMain.class);
        startActivity(intent);
    }
    private  void moveToShowSchedling(){
        Intent intent = new Intent(this, WorkSchedling.class);
        startActivity(intent);
    }
    private  void moveToShowReminders(){
        Intent intent = new Intent(this, Remainders.class);
        startActivity(intent);
    }
    private  void moveToShowHealth(){
        Intent intent = new Intent(this, Health.class);
        startActivity(intent);
    }
    private  void moveToShowSocial(){
        Intent intent = new Intent(this, Social.class);
        startActivity(intent);
    }
}