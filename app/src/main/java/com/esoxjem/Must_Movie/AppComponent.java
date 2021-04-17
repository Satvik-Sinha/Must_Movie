package com.esoxjem.Must_Movie;

import com.esoxjem.Must_Movie.details.DetailsComponent;
import com.esoxjem.Must_Movie.details.DetailsModule;
import com.esoxjem.Must_Movie.favorites.FavoritesModule;
import com.esoxjem.Must_Movie.listing.ListingComponent;
import com.esoxjem.Must_Movie.listing.ListingModule;
import com.esoxjem.Must_Movie.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class,
        FavoritesModule.class})
public interface AppComponent {
    DetailsComponent plus(DetailsModule detailsModule);

    ListingComponent plus(ListingModule listingModule);
}
