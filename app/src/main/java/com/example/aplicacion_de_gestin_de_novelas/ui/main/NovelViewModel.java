package com.example.aplicacion_de_gestin_de_novelas.ui.main;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.rep.NovelRepository;
import java.util.List;

public class NovelViewModel extends AndroidViewModel {
    private final NovelRepository repository;
    private final LiveData<List<Novel>> allNovels;
    private final LiveData<List<Novel>> favoriteNovels; // Añadir esta línea

    public NovelViewModel(@NonNull Application application) {
        super(application);
        repository = new NovelRepository(application);
        allNovels = repository.getAllNovels();
        favoriteNovels = repository.getFavoriteNovels(); // Obtener novelas favoritas
    }

    public LiveData<List<Novel>> getAllNovels() {
        return allNovels;
    }

    public LiveData<List<Novel>> getFavoriteNovels() {
        return favoriteNovels; // Retornar novelas favoritas
    }

    // Métodos para insertar, actualizar y eliminar
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
