package com.example.vetcription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.vetcription.Database.Veterinary_DataModel;

import java.util.List;

public class new_search_medicine extends AppCompatActivity {
    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    SearchView searchView;
    RecyclerView medicine_list;
    private Vet_ViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_search_medicine);
        viewModel=new ViewModelProvider(this).get(Vet_ViewModel.class);
        medicine_list=findViewById(R.id.recyclerview);
        final VetDataShowAdapter_saiful adapter = new VetDataShowAdapter_saiful(this);
        medicine_list.setAdapter(adapter);
        medicine_list.setLayoutManager(new LinearLayoutManager(this));
        viewModel.getAllData().observe(this, new Observer<List<Veterinary_DataModel>>() {
            @Override
            public void onChanged(List<Veterinary_DataModel> veterinary_dataModels) {
                adapter.setWords(veterinary_dataModels);
            }
        });
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