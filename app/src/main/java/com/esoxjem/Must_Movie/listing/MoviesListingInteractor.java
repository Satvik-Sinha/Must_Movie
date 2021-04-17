package com.esoxjem.Must_Movie.listing;

import com.esoxjem.Must_Movie.Movie;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesListingInteractor {
    boolean isPaginationSupported();

    Observable<List<Movie>> fetchMovies(int page);

    Observable<List<Movie>> searchMovie(String searchQuery);
}
