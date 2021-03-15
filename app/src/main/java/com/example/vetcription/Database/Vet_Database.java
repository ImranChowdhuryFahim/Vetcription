package com.example.vetcription.Database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Veterinary_DataModel.class},version = 1,exportSchema = false)
public abstract class Vet_Database extends RoomDatabase {

    public abstract Vet_Dao vet_dao();

    private static volatile Vet_Database INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static Vet_Database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (Vet_Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Vet_Database.class, "word_database")
                            .createFromAsset("database/data.sqlite")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                Vet_Dao dao = INSTANCE.vet_dao();
                dao.deleteAll();

                Veterinary_DataModel vd = new Veterinary_DataModel("Ielmex","600mg",	"1b/80kg",	"Reneta",	"Albendazole",	"Bolus","",""	);
                dao.insert(vd);

            });
        }
    };
}
