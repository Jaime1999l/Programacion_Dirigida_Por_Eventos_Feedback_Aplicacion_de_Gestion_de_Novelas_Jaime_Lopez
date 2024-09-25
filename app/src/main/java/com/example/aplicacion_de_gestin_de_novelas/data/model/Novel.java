package com.example.aplicacion_de_gestin_de_novelas.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "novel_table")
public class Novel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String author;
    private int year;
    private String synopsis;
    private boolean favorite;

    public Novel(String title, String author, int year, String synopsis) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.synopsis = synopsis;
        this.favorite = false;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public String getSynopsis() { return synopsis; }
    public boolean isFavorite() { return favorite; }
    public void setFavorite(boolean favorite) { this.favorite = favorite; }
}


