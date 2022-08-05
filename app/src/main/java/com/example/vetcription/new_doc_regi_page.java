package com.example.vetcription;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class new_doc_regi_page extends AppCompatActivity {
    EditText name,regi_num,mobile_no,email,password,confirm_password;
    Button sign_up;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        mAuth = FirebaseAuth.getInstance();
        //assign
        name=findViewById(R.id.doc_name);
        regi_num=findViewById(R.id.doc_regi);
        mobile_no=findViewById(R.id.doc_mobile_no);
        email=findViewById(R.id.doc_email);
        password=findViewById(R.id.doc_password);
        confirm_password=findViewById(R.id.doc_confirm_password);
        sign_up=findViewById(R.id.doc_sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                docregi();
               // startActivity(new Intent(new_doc_regi_page.this,New_doc_dashboard.class));

            }
        });


    }

    private void docregi() {
        String d_name,d_regi,d_mobile,d_password,d_mail,d_c_password;
        d_name=name.getText().toString();
        d_regi=regi_num.getText().toString();
        d_mobile=mobile_no.getText().toString();
        d_mail=email.getText().toString();
        d_c_password=confirm_password.getText().toString();
        d_password=password.getText().toString();

        int tf=0;
        if(!d_c_password.equals(d_password)){
            seterror(confirm_password,"Password Did Not Matched");
            tf++;

        }
        if(d_c_password.length()<6){
            seterror(confirm_password,"At Least 6 Character");
            tf++;
        }

        if(d_password.length()<6){
            seterror(password,"At Least 6 Character");
            tf++;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(d_mail).matches()){
            seterror(email,"Invalid Mail");
            tf++;
        }
        if(d_mobile.length()!=11){
            seterror(mobile_no,"Enter Exact 11 digit");
            tf++;
        }
        if(d_regi.isEmpty()){
            seterror(regi_num,"Invalid Regi Number");
            tf++;
        }
        if(d_name.isEmpty()){
            seterror(name,"Invalid Name");
            tf++;
        }
        if(tf>0){
            return;
        }
        mAuth.createUserWithEmailAndPassword(d_mail,d_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Doctor u=new Doctor(d_name,d_regi,d_mobile,d_mail,d_password);
                    FirebaseDatabase.getInstance().getReference("Doctors")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(u).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()) {
                                        Toast.makeText(new_doc_regi_page.this, "Successfull", Toast.LENGTH_SHORT).show();
                                        finishAffinity();
                                        startActivity(new Intent(new_doc_regi_page.this,New_doc_dashboard.class));
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(new_doc_regi_page.this, "Failed", Toast.LENGTH_SHORT).show();
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
}