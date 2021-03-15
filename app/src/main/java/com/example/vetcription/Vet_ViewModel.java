package com.example.vetcription;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.vetcription.Database.Vet_Repository;
import com.example.vetcription.Database.Veterinary_DataModel;

import java.util.List;

public class Vet_ViewModel extends AndroidViewModel {
    private Vet_Repository repository;
    private LiveData<List<Veterinary_DataModel>> allData,searched_data;
    public Vet_ViewModel(@NonNull Application application) {
        super(application);
        repository=new Vet_Repository(application);
        allData=repository.getAllData();
    }

    LiveData<List<Veterinary_DataModel>> getAllData()
    {
        return allData;
    }
    LiveData<List<Veterinary_DataModel>> getSearched_data(String search)
    { return repository.getSearched_data(search); }
    public void update(Veterinary_DataModel vd)
    {
        repository.update(vd);
    }

    public void delete(Veterinary_DataModel vd)
    {
        repository.delete(vd);
    }

    public void insert(Veterinary_DataModel vd)
    {
        repository.insert(vd);
    }

    public void deleteall()
    {
        repository.deleteall();
    }
}
