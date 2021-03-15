package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registration_Activity extends AppCompatActivity {
    private TextView doc_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        doc_reg=findViewById(R.id.doc_reg);
        doc_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Registration_Activity.this,Doc_Registration_Activity.class);
                startActivity(intent);
            }
        });
    }
}
