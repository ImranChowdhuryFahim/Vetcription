package com.example.vetcription.Database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Vet_Repository {
    private Vet_Dao vet_dao;
    private LiveData<List<Veterinary_DataModel>> allData,searched_data;

    public Vet_Repository(Application application)
    {
        Vet_Database database=Vet_Database.getDatabase(application);
        vet_dao = database.vet_dao();
        allData=vet_dao.getAlldata();
    }

    public void insert(Veterinary_DataModel vd)
    {
           Vet_Database.databaseWriteExecutor.execute(() ->{
               vet_dao.insert(vd);
           });
    }

    public void update(Veterinary_DataModel vd)
    {
        Vet_Database.databaseWriteExecutor.execute(() ->{
            vet_dao.update(vd);
        });

    }

    public void delete(Veterinary_DataModel vd)
    {
        Vet_Database.databaseWriteExecutor.execute(() ->{
            vet_dao.delete(vd);
        });
    }

    public void deleteall()
    {
        Vet_Database.databaseWriteExecutor.execute(() ->{
            vet_dao.deleteAll();
        });
    }

    public  LiveData<List<Veterinary_DataModel>> getAllData()
    {
        return allData;
    }
    public  LiveData<List<Veterinary_DataModel>> getSearched_data(String search)
    {
        return vet_dao.getSearcheddata(search);
    }


}
