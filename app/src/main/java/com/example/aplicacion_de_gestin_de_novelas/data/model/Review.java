package com.example.aplicacion_de_gestin_de_novelas.data.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "review_table")
public class Review {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int novelId;
    private String reviewer;
    private String comment;
    private int rating;

    public Review(int novelId, String reviewer, String comment, int rating) {
        this.novelId = novelId;
        this.reviewer = reviewer;
        this.comment = comment;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNovelId() {
        return novelId;
    }

    public String getReviewer() {
        return reviewer;
    }

    public String getComment() {
        return comment;
    }

    public int getRating() {
        return rating;
    }
}

