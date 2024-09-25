package com.example.aplicacion_de_gestin_de_novelas.ui.addeditnovel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicacion_de_gestin_de_novelas.R;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Novel;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;

import java.util.List;

public class AddEditNovelActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAuthor, editTextYear, editTextSynopsis;
    private Button buttonSave;
    private AddEditNovelViewModel addEditNovelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_novel);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextAuthor = findViewById(R.id.edit_text_author);
        editTextYear = findViewById(R.id.edit_text_year);
        editTextSynopsis = findViewById(R.id.edit_text_synopsis);
        buttonSave = findViewById(R.id.button_save);

        addEditNovelViewModel = new ViewModelProvider(this).get(AddEditNovelViewModel.class);

        final Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("EXTRA_ID")) {
            setTitle("Editar Novela");
            addEditNovelViewModel.setNovelId(extras.getInt("EXTRA_ID"));
            addEditNovelViewModel.getNovel().observe(this, new Observer<Novel>() {
                @Override
                public void onChanged(Novel novel) {
                    if (novel != null) {
                        editTextTitle.setText(novel.getTitle());
                        editTextAuthor.setText(novel.getAuthor());
                        editTextYear.setText(String.valueOf(novel.getYear()));
                        editTextSynopsis.setText(novel.getSynopsis());
                    }
                }
            });
        } else {
            setTitle("Agregar Novela");
        }

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNovel();
            }
        });
    }

    private void saveNovel() {
        String title = editTextTitle.getText().toString().trim();
        String author = editTextAuthor.getText().toString().trim();
        String yearString = editTextYear.getText().toString().trim();
        String synopsis = editTextSynopsis.getText().toString().trim();

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(author) || TextUtils.isEmpty(yearString) || TextUtils.isEmpty(synopsis)) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        int year = Integer.parseInt(yearString);
        Novel novel = new Novel(title, author, year, synopsis);

        if (getIntent().hasExtra("EXTRA_ID")) {
            novel.setId(getIntent().getIntExtra("EXTRA_ID", -1));
            addEditNovelViewModel.saveNovel(novel);
            Toast.makeText(this, "Novela actualizada", Toast.LENGTH_SHORT).show();
        } else {
            addEditNovelViewModel.saveNovel(novel);
            Toast.makeText(this, "Novela agregada", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}

