package com.example.aplicacion_de_gestin_de_novelas.data.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;

import java.util.List;

@Dao
public interface NovelDao {
    @Insert
    void insert(Novel novel);

    @Update
    void update(Novel novel);

    @Delete
    void delete(Novel novel);

    @Query("SELECT * FROM novel_table ORDER BY title ASC")
    LiveData<List<Novel>> getAllNovels();

    @Query("SELECT * FROM novel_table WHERE id = :novelId LIMIT 1")
    LiveData<Novel> getNovelById(int novelId);

    @Insert
    void addReview(Review review);

    @Query("SELECT * FROM review_table WHERE novelId = :novelId ORDER BY id DESC")
    LiveData<List<Review>> getReviewsForNovel(int novelId);
}

