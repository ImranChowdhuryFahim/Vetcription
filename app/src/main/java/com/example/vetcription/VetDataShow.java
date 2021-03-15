package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vetcription.Database.Veterinary_DataModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VetDataShow extends AppCompatActivity {
    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    private Vet_ViewModel viewModel;
//    private FloatingActionButton floatingActionButton;
    private EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_data_show);
        search=findViewById(R.id.search);
        viewModel=new ViewModelProvider(this).get(Vet_ViewModel.class);
//        floatingActionButton=findViewById(R.id.fab);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final VetDataShowAdapter adapter = new VetDataShowAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.getAllData().observe(this, new Observer<List<Veterinary_DataModel>>() {
            @Override
            public void onChanged(List<Veterinary_DataModel> veterinary_dataModels) {
                adapter.setWords(veterinary_dataModels);
            }
        });

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.getSearched_data("%"+charSequence.toString()+"%").observe(VetDataShow.this, new Observer<List<Veterinary_DataModel>>() {
                    @Override
                    public void onChanged(List<Veterinary_DataModel> veterinary_dataModels) {
                        adapter.setWords(veterinary_dataModels);
                    }
                });

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(VetDataShow.this, Add_Medicine.class);
//                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
//            }
//        });




    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String[] s = data.getStringArrayExtra(Add_Medicine.EXTRA_REPLY);
            Veterinary_DataModel vd=new Veterinary_DataModel(s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
            viewModel.insert(vd);


        }
    }
}
