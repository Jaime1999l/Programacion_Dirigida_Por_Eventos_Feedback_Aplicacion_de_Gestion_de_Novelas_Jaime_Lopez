package com.example.aplicacion_de_gestin_de_novelas.ui.review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.aplicacion_de_gestin_de_novelas.R;
import com.example.aplicacion_de_gestin_de_novelas.data.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewHolder> {
    private List<Review> reviews = new ArrayList<>();

    @NonNull
    @Override
    public ReviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_item, parent, false);
        return new ReviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewHolder holder, int position) {
        Review currentReview = reviews.get(position);
        holder.textViewReviewer.setText(currentReview.getReviewer());
        holder.textViewComment.setText(currentReview.getComment());
        holder.textViewRating.setText("Puntuación: " + currentReview.getRating());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    class ReviewHolder extends RecyclerView.ViewHolder {
        private TextView textViewReviewer;
        private TextView textViewComment;
        private TextView textViewRating;

        public ReviewHolder(View itemView) {
            super(itemView);
            textViewReviewer = itemView.findViewById(R.id.text_view_reviewer);
            textViewComment = itemView.findViewById(R.id.text_view_comment);
            textViewRating = itemView.findViewById(R.id.text_view_rating);
        }
    }
}

