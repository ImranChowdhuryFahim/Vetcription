package com.example.vetcription;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class New_login extends AppCompatActivity {
    EditText user_name,password;
    Button forget_password,log_in,sign_up_doctor,sign_up_user;
    ConstraintLayout root;
    private FirebaseAuth mauth;

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
        mauth=FirebaseAuth.getInstance();
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email,pass;
                email=user_name.getText().toString();
                pass=password.getText().toString();
                int tf=0;

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    tf=1;
                    user_name.setError("Invalid email");
                    user_name.requestFocus();
                }
                if(pass.length()<6)
                {
                    password.setError("Invalid Password");
                    password.requestFocus();
                    tf++;
                }
                if(tf>0)
                {
                    return;
                }

                mauth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {


                            startActivity(new Intent(New_login.this, New_doc_dashboard.class));
                            finish();
                        }else{

                            Toast.makeText(New_login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



                String value=password.getText().toString();


                if(value.equals("1"))
                {

                    startActivity(new Intent(New_login.this, New_user_dashboard.class));
                }
                if(value.equals("2"))
                {
                    startActivity(new Intent(New_login.this, New_doc_dashboard.class));
                }
            }
        });
        sign_up_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_login.this,user_registration.class));
            }
        });
        sign_up_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_login.this, new_doc_regi_page.class));
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