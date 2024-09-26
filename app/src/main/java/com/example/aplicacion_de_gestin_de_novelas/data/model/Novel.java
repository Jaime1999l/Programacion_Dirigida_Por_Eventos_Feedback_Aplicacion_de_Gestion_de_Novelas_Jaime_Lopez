package com.example.aplicacion_de_gestin_de_novelas.data.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "novel_table")
public class Novel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private final String title;

    @NonNull
    private final String author;

    private final int year;

    @NonNull
    private final String synopsis;

    private boolean favorite;
    private String imageUri;

    public Novel(@NonNull String title, @NonNull String author, int year, @NonNull String synopsis, String imageUri) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
        this.favorite = false;
        this.imageUri = imageUri;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @NonNull
    public String getTitle() { return title; }
    @NonNull
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    @NonNull
    public String getSynopsis() { return synopsis; }
    public boolean isFavorite() { return favorite; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }
    public String getImageUri() {
        return imageUri;
    }
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}


