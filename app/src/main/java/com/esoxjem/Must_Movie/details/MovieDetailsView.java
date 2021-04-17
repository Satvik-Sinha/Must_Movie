package com.esoxjem.Must_Movie.details;

import com.esoxjem.Must_Movie.Movie;
import com.esoxjem.Must_Movie.Review;
import com.esoxjem.Must_Movie.Video;

import java.util.List;

interface MovieDetailsView {
    void showDetails(Movie movie);

    void showTrailers(List<Video> trailers);

    void showReviews(List<Review> reviews);

    void showFavorited();

    void showUnFavorited();
}
