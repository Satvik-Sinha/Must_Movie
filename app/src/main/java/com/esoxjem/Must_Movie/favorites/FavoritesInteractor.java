package com.esoxjem.Must_Movie.favorites;

import com.esoxjem.Must_Movie.Movie;

import java.util.List;

public interface FavoritesInteractor {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);
}
