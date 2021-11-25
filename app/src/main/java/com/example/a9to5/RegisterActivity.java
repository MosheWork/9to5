package com.example.a9to5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class RegisterActivity extends AppCompatActivity {

    EditText emailEt,passEt,confirm_pass;
    Button register_btn,login_btn;
    CheckBox checkBox;
    ProgressBar progressBar;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEt=findViewById(R.id.register_email_et);
        passEt=findViewById(R.id.register_password_et);
        confirm_pass=findViewById(R.id.register_confirm_password_et);
        register_btn=findViewById(R.id.button_register);
        login_btn=findViewById(R.id.signup_to_login);
        checkBox=findViewById(R.id.register_checkbox);
        progressBar=findViewById(R.id.progressbar_Register);
        mAuth=FirebaseAuth.getInstance();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    passEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    confirm_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    passEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    confirm_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email= emailEt.getText().toString();
                String pass= passEt.getText().toString();
                String confirm_password= confirm_pass.getText().toString();

                if(!TextUtils.isEmpty(email) || !TextUtils.isEmpty(pass) || !TextUtils.isEmpty(confirm_password)){

                    if (pass.equals(confirm_password)){
                        progressBar.setVisibility(View.VISIBLE);
                        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    sendtoMain();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }else{
                                    String error=task.getException().getMessage();
                                    Toast.makeText(RegisterActivity.this,"error :"+ error,Toast.LENGTH_LONG).show();

                                }
                            }
                        });



                    }else {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(RegisterActivity.this,"password and confirm password is nott matching",Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(RegisterActivity.this,"Please Fill all Fields",Toast.LENGTH_LONG).show();
                }
                    }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
        }

    private void sendtoMain() {
        Intent intent = new Intent(RegisterActivity.this,Splashscreen.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onStart(){
        super.onStart();

        FirebaseUser  user =FirebaseAuth.getInstance().getCurrentUser();
        if (user!=null){
            sendtoMain();
        }
    }


}
