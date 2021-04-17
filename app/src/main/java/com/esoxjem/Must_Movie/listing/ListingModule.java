package com.esoxjem.Must_Movie.listing;

import com.esoxjem.Must_Movie.favorites.FavoritesInteractor;
import com.esoxjem.Must_Movie.listing.sorting.SortingOptionStore;
import com.esoxjem.Must_Movie.network.TmdbWebService;

import dagger.Module;
import dagger.Provides;

@Module
public class ListingModule {
    @Provides
    MoviesListingInteractor provideMovieListingInteractor(FavoritesInteractor favoritesInteractor,
                                                          TmdbWebService tmdbWebService,
                                                          SortingOptionStore sortingOptionStore) {
        return new MoviesListingInteractorImpl(favoritesInteractor, tmdbWebService, sortingOptionStore);
    }

    @Provides
    MoviesListingPresenter provideMovieListingPresenter(MoviesListingInteractor interactor) {
        return new MoviesListingPresenterImpl(interactor);
    }
}
