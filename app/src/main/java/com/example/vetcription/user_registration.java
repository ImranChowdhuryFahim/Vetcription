package com.example.vetcription;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class user_registration extends AppCompatActivity {
    EditText name,mobile_no,email,password,confirm_password;
    Button sign_up;
    private FirebaseAuth mAuth;


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
        mAuth=FirebaseAuth.getInstance();

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userregi();
               // startActivity(new Intent(user_registration.this,New_user_dashboard.class));
            }
        });


    }

    private void userregi() {
        String u_name,u_email,u_password,u_c_password,u_mobile;
        u_name=name.getText().toString();
        u_mobile=mobile_no.getText().toString();
        u_email=email.getText().toString();
        u_password=password.getText().toString();
        u_c_password=confirm_password.getText().toString();
        int tf=0;

        if(!u_c_password.equals(u_password)){
            seterror(confirm_password,"Password Did Not Matched");
            tf++;
        }
        if(u_c_password.length()<6){
            seterror(confirm_password,"At Least 6 Character");
            tf++;
        }
        if(u_password.length()<6){
            seterror(password,"At Least 6 Character");
            tf++;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(u_email).matches()){
            seterror(email,"Invalid Mail");
            tf++;
        }
        if(u_mobile.length()!=11){
            seterror(mobile_no,"11 Digit only");
            tf++;
        }
        if(u_name.isEmpty()){
            seterror(name,"Invalid Name");
            tf++;
        }

        if(tf!=0){
            return;
        }
        mAuth.createUserWithEmailAndPassword(u_email,u_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    User u=new User(u_name,u_mobile,u_email,u_password);
                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(user_registration.this, "Successfull", Toast.LENGTH_SHORT).show();
                                        finishAffinity();
                                        startActivity(new Intent(user_registration.this,New_user_dashboard.class));
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(user_registration.this, "Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }
            }
        });



    }

    private void seterror(EditText t, String message) {
         t.setError(message);
         t.requestFocus();

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