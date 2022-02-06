package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.vetcription.R;

public class New_login extends AppCompatActivity {
    EditText user_name,password;
    Button forget_password,log_in,sign_up_doctor,sign_up_user;
    ConstraintLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);
        //assign
        user_name=findViewById(R.id.username);
        password=findViewById(R.id.password);
        forget_password=findViewById(R.id.forget_password);
        log_in=findViewById(R.id.log_in);
        sign_up_doctor=findViewById(R.id.sign_up_doctor);
        sign_up_user=findViewById(R.id.sign_up_user);
        root=findViewById(R.id.root);
        animation();
        sign_up_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_login.this,user_registration.class));
            }
        });
    }

    private void animation() {
        Animation leftoright= AnimationUtils.loadAnimation(New_login.this,R.anim.lefttoright);
        Animation righttoleft=AnimationUtils.loadAnimation(New_login.this,R.anim.righttoleft);
        Animation bottomtoup=AnimationUtils.loadAnimation(New_login.this,R.anim.bottomtotop);
        Animation alpha=AnimationUtils.loadAnimation(New_login.this,R.anim.visibility);
        root.setAnimation(alpha);
        user_name.setAnimation(leftoright);
        password.setAnimation(righttoleft);
        forget_password.setAnimation(leftoright);
        log_in.setAnimation(righttoleft);
        sign_up_user.setAnimation(bottomtoup);
        sign_up_doctor.setAnimation(bottomtoup);
    }
}