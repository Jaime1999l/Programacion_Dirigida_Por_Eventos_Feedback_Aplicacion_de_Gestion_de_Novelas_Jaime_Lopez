package com.example.aplicacion_de_gestin_de_novelas.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;

@Database(entities = {Novel.class, Review.class}, version = 1, exportSchema = false)
public abstract class NovelDataBase extends RoomDatabase {
    private static NovelDataBase instance;

    public abstract NovelDao novelDao();

    public static synchronized NovelDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            NovelDatabase.class, "novel_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

