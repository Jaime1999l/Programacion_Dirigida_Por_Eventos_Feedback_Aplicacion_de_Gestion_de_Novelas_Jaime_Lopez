package com.example.aplicacion_de_gestin_de_novelas.ui.favoritesNovel;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.aplicacion_de_gestin_de_novelas.R;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.ui.main.NovelViewModel;

import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private FavoritesAdapter favoritesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites_activity);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        favoritesAdapter = new FavoritesAdapter();
        recyclerView.setAdapter(favoritesAdapter);

        NovelViewModel novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        novelViewModel.getFavoriteNovels().observe(this, new Observer<List<Novel>>() {
            @Override
            public void onChanged(List<Novel> novels) {
                favoritesAdapter.setNovels(novels);
            }
        });
    }
}


