package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class splash_screen extends AppCompatActivity {
    ConstraintLayout root;
    TextView logo;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //assign
        root=findViewById(R.id.splash_root);
        logo=findViewById(R.id.logo);
        next=findViewById(R.id.next);

        animation();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(splash_screen.this,New_login.class));
                finish();
            }
        });
    }

    private void animation() {
        Animation bottomtotop= AnimationUtils.loadAnimation(splash_screen.this,R.anim.bottomtotop);
        Animation alpha=AnimationUtils.loadAnimation(splash_screen.this,R.anim.visibility);
        root.setAnimation(alpha);
        logo.setAnimation(bottomtotop);
        next.setAnimation(bottomtotop);
    }
}