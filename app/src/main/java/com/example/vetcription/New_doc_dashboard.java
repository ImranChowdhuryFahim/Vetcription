package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class New_doc_dashboard extends AppCompatActivity {
    RelativeLayout search_medicine,search_disease,nearby,saved_medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doc_dashboard);
        //assign
        search_medicine=findViewById(R.id.doc_search_medicine);
        search_disease=findViewById(R.id.doc_disease);
        nearby=findViewById(R.id.doc_pending_request);
        saved_medicine=findViewById(R.id.doc_saved_medicine);

        search_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_doc_dashboard.this,new_search_medicine.class));
            }
        });
        search_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_doc_dashboard.this,Disease.class));
            }
        });
        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_doc_dashboard.this,Pending_request.class));
            }
        });
        saved_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_doc_dashboard.this,new_search_medicine.class));
            }
        });


    }
}