package com.example.aplicacion_de_gestin_de_novelas.data.rep;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.aplicacion_de_gestin_de_novelas.data.dataBase.NovelDataBase;
import com.example.aplicacion_de_gestin_de_novelas.data.dataBase.NovelDao;
import com.example.aplicacion_de_gestin_de_novelas.data.dataBase.NovelDataBase;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NovelRepository {
    private NovelDao novelDao;
    private LiveData<List<Novel>> allNovels;
    private final ExecutorService executorService;

    public NovelRepository(Application application) {
        NovelDataBase database = NovelDataBase.getInstance(application);
        novelDao = database.novelDao();
        allNovels = novelDao.getAllNovels();
        executorService = Executors.newFixedThreadPool(2);
    }

    public void insert(Novel novel) {
        executorService.execute(() -> novelDao.insert(novel));
    }

    public void update(Novel novel) {
        executorService.execute(() -> novelDao.update(novel));
    }

    public void delete(Novel novel) {
        executorService.execute(() -> novelDao.delete(novel));
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }

    public LiveData<Novel> getNovelById(int novelId) {
        return novelDao.getNovelById(novelId);
    }

    public void addReview(Review review) {
        executorService.execute(() -> novelDao.addReview(review));
    }

    public LiveData<List<Review>> getReviewsForNovel(int novelId) {
        return novelDao.getReviewsForNovel(novelId);
    }
}

