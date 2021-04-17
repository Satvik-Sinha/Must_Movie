package com.esoxjem.Must_Movie;

import android.app.Application;
import android.os.StrictMode;

import com.esoxjem.Must_Movie.details.DetailsComponent;
import com.esoxjem.Must_Movie.details.DetailsModule;
import com.esoxjem.Must_Movie.favorites.FavoritesModule;
import com.esoxjem.Must_Movie.listing.ListingComponent;
import com.esoxjem.Must_Movie.listing.ListingModule;
import com.esoxjem.Must_Movie.network.NetworkModule;

import io.realm.Realm;

public class BaseApplication extends Application {
    private AppComponent appComponent;
    private DetailsComponent detailsComponent;
    private ListingComponent listingComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
        initRealm();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .favoritesModule(new FavoritesModule())
                .build();
    }

    private void initRealm() {
        Realm.init(this);
    }

    public DetailsComponent createDetailsComponent() {
        detailsComponent = appComponent.plus(new DetailsModule());
        return detailsComponent;
    }

    public void releaseDetailsComponent() {
        detailsComponent = null;
    }

    public ListingComponent createListingComponent() {
        listingComponent = appComponent.plus(new ListingModule());
        return listingComponent;
    }

    public void releaseListingComponent() {
        listingComponent = null;
    }

    public ListingComponent getListingComponent() {
        return listingComponent;
    }
}
