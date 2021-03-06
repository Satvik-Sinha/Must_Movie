package com.esoxjem.Must_Movie.listing;

import com.esoxjem.Must_Movie.Movie;

import java.util.List;

interface MoviesListingView {
    void showMovies(List<Movie> movies);

    void loadingStarted();

    void loadingFailed(String errorMessage);

    void onMovieClicked(Movie movie);
}
