package com.example.aplicacion_de_gestin_de_novelas.ui.addeditnovel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;
import com.example.aplicacion_de_gestin_de_novelas.data.repository.NovelRepository;

import java.util.List;

public class AddEditNovelViewModel extends AndroidViewModel {
    private NovelRepository repository;
    private LiveData<Novel> novel;
    private LiveData<List<Review>> reviews;

    public AddEditNovelViewModel(@NonNull Application application) {
        super(application);
        repository = new NovelRepository(application);
    }

    public void setNovelId(int novelId) {
        novel = repository.getNovelById(novelId);
        reviews = repository.getReviewsForNovel(novelId);
    }

    public LiveData<Novel> getNovel() {
        return novel;
    }

    public LiveData<List<Review>> getReviews() {
        return reviews;
    }

    public void saveNovel(Novel novel) {
        if (novel.getId() == 0) {
            repository.insert(novel);
        } else {
            repository.update(novel);
        }
    }

    public void deleteNovel(Novel novel) {
        repository.delete(novel);
    }

    public void addReview(Review review) {
        repository.addReview(review);
    }

    public void toggleFavorite(Novel novel) {
        novel.setFavorite(!novel.isFavorite());
        repository.update(novel);
    }
}

