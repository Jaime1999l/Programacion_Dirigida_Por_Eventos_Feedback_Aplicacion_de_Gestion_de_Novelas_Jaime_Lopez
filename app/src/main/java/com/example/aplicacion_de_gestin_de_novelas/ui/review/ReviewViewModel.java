package com.example.aplicacion_de_gestin_de_novelas.ui.review;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;
import com.example.aplicacion_de_gestin_de_novelas.data.rep.NovelRepository;

import java.util.List;

public class ReviewViewModel extends AndroidViewModel {
    private final NovelRepository repository;

    public ReviewViewModel(@NonNull Application application) {
        super(application);
        repository = new NovelRepository(application);
    }

    public LiveData<List<Review>> getReviewsForNovel(int novelId) {
        return repository.getReviewsForNovel(novelId);
    }

    public void addReview(Review review) {
        repository.addReview(review);
    }
}

