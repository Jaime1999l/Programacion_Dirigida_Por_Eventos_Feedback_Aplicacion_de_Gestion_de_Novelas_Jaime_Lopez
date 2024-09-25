package com.example.aplicacion_de_gestin_de_novelas.ui.main;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.rep.NovelRepository;
import java.util.List;

public class NovelViewModel extends AndroidViewModel {
    private NovelRepository repository;
    private LiveData<List<Novel>> allNovels;

    public NovelViewModel(@NonNull Application application) {
        super(application);
        repository = new NovelRepository(application);
        allNovels = repository.getAllNovels();
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }

    public void insert(Novel novel) {
        repository.insert(novel);
    }

    public void update(Novel novel) {
        repository.update(novel);
    }

    public void delete(Novel novel) {
        repository.delete(novel);
    }
}


