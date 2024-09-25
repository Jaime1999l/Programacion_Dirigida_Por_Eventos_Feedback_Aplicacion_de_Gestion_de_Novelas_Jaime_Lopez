package com.example.aplicacion_de_gestin_de_novelas.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aplicacion_de_gestin_de_novelas.R;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.ui.addeditnovel.AddEditNovelActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddBook;
    private RecyclerView recyclerView;
    private NovelViewModel novelViewModel;
    private NovelAdapter novelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddBook = findViewById(R.id.buttonAddBook);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        novelAdapter = new NovelAdapter();
        recyclerView.setAdapter(novelAdapter);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        novelViewModel.getAllNovels().observe(this, new Observer<List<Novel>>() {
            @Override
            public void onChanged(List<Novel> novels) {
                novelAdapter.setNovels(novels);
            }
        });

        buttonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditNovelActivity.class);
                startActivity(intent);
            }
        });

        novelAdapter.setOnItemClickListener(new NovelAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Novel novel) {
                Intent intent = new Intent(MainActivity.this, AddEditNovelActivity.class);
                intent.putExtra("EXTRA_ID", novel.getId());
                intent.putExtra("EXTRA_TITLE", novel.getTitle());
                intent.putExtra("EXTRA_AUTHOR", novel.getAuthor());
                intent.putExtra("EXTRA_YEAR", novel.getYear());
                intent.putExtra("EXTRA_SYNOPSIS", novel.getSynopsis());
                startActivity(intent);
            }

            @Override
            public void onFavoriteClick(Novel novel) {
                novelViewModel.update(new Novel(novel.getId(), novel.getTitle(), novel.getAuthor(), novel.getYear(), novel.getSynopsis(), !novel.isFavorite()));
                Toast.makeText(MainActivity.this, "Favorito actualizado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

