package com.example.vetcription.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Vet_Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Veterinary_DataModel vd);

    @Update
    void update(Veterinary_DataModel vd);

    @Delete
    void delete(Veterinary_DataModel vd);

    @Query("DELETE FROM vet_data")
    void deleteAll();

    @Query("SELECT * FROM vet_data ORDER BY id DESC")
    LiveData<List<Veterinary_DataModel>> getAlldata();

    @Query("SELECT * FROM vet_data WHERE trade_name LIKE :search OR generic_name LIKE :search")
    LiveData<List<Veterinary_DataModel>> getSearcheddata(String search);
}

