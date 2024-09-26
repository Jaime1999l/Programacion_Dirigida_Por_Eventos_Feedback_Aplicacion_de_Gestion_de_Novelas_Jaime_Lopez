package com.example.aplicacion_de_gestin_de_novelas.ui.addeditnovel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;
import com.example.aplicacion_de_gestin_de_novelas.data.rep.NovelRepository;

import java.util.List;

public class AddEditNovelViewModel extends AndroidViewModel {
    private final NovelRepository repository;
    private LiveData<Novel> novel;
    private LiveData<List<Review>> reviews;

    public AddEditNovelViewModel(@NonNull Application application) {
        super(application);
        repository = new NovelRepository(application);
    }

    // Método para obtener una novela por ID
    public LiveData<Novel> getNovelById(int novelId) {
        return repository.getNovelById(novelId);
    }

    // Devuelve la novela actual
    public LiveData<Novel> getNovel() {
        return novel;
    }

    // Devuelve las reseñas de la novela
    public LiveData<List<Review>> getReviews() {
        return reviews;
    }

    // Guarda la novela en la base de datos
    public void saveNovel(Novel novel) {
        if (novel.getId() == 0) { // Si es una novela nueva
            repository.insert(novel);
        } else { // Si es una novela existente
            repository.update(novel);
        }
    }
}
