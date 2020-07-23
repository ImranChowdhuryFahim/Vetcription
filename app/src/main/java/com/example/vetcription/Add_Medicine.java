package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vetcription.Database.Veterinary_DataModel;

import java.util.ArrayList;
import java.util.List;

public class Add_Medicine extends AppCompatActivity {

    private EditText trade_name,trade_dose,company,composition,comments,details,generic_name,pack_size;

    private Button save;
    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__medicine);
        trade_name=findViewById(R.id.add_trade_name);
        trade_dose=findViewById(R.id.add_trade_dose);
        company=findViewById(R.id.add_company);
        composition=findViewById(R.id.add_compostion);
        comments=findViewById(R.id.add_comments);
        details=findViewById(R.id.add_details);
        generic_name=findViewById(R.id.add_generic_name);
        pack_size=findViewById(R.id.add_pack_size);

        save=findViewById(R.id.button_save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                String[] s={trade_name.getText().toString(),composition.getText().toString(),trade_dose.getText().toString(),company.getText().toString(),generic_name.getText().toString(),comments.getText().toString(),pack_size.getText().toString(),details.getText().toString()};
                    replyIntent.putExtra(EXTRA_REPLY, s);
                    setResult(RESULT_OK, replyIntent);

                finish();
            }
        });



    }
}
