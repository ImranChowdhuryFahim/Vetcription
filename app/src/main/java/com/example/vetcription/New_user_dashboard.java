package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class New_user_dashboard extends AppCompatActivity {
    RelativeLayout search_medicine,search_disease,nearby,saved_medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_dashboard);
        //assign
        search_medicine=findViewById(R.id.user_search_medicine);
        search_disease=findViewById(R.id.user_disease);
        nearby=findViewById(R.id.user_nearby);
        saved_medicine=findViewById(R.id.user_saved_medicine);

        search_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_user_dashboard.this,VetDataShow.class));
            }
        });
        search_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_user_dashboard.this,Disease.class));
            }
        });
        nearby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_user_dashboard.this,Nearby.class));
            }
        });
        saved_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(New_user_dashboard.this,new_search_medicine.class));
            }
        });
    }
}