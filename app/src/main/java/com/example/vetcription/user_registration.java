package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

public class user_registration extends AppCompatActivity {
    EditText name,mobile_no,email,password,confirm_password;
    Button sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_regi);
        name=findViewById(R.id.user_name);
        mobile_no=findViewById(R.id.user_mobile_no);
        email=findViewById(R.id.user_email);
        password=findViewById(R.id.user_regi_password);
        confirm_password=findViewById(R.id.user_regi_confirm_password);
        sign_up=findViewById(R.id.user_regi_sign_up);


    }

    private void animation() {
        Animation lefttoright= AnimationUtils.loadAnimation(user_registration.this,R.anim.lefttoright);
        Animation righttoleft=AnimationUtils.loadAnimation(user_registration.this,R.anim.righttoleft);
        Animation bottomtotop=AnimationUtils.loadAnimation(user_registration.this,R.anim.bottomtotop);
        name.setAnimation(lefttoright);
        mobile_no.setAnimation(righttoleft);
        email.setAnimation(lefttoright);
        password.setAnimation(righttoleft);
        confirm_password.setAnimation(lefttoright);
        sign_up.setAnimation(bottomtotop);

    }
}