package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Doc_Registration_Activity extends AppCompatActivity {
    EditText name,regi_num,mobile_no,email,password,confirm_password;
    Button sign_up;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc__registration_);
        //assign
        name=findViewById(R.id.doc_name);
        regi_num=findViewById(R.id.doc_regi);
        mobile_no=findViewById(R.id.doc_mobile_no);
        email=findViewById(R.id.doc_email);
        password=findViewById(R.id.doc_password);
        confirm_password=findViewById(R.id.doc_confirm_password);
        sign_up=findViewById(R.id.doc_sign_up);

    }
}