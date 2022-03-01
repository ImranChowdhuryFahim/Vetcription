package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class new_doc_regi_page extends AppCompatActivity {
    EditText name,regi_num,mobile_no,email,password,confirm_password;
    Button sign_up;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doc_regi_page);
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
                startActivity(new Intent(new_doc_regi_page.this,New_doc_dashboard.class));

            }
        });


    }
}