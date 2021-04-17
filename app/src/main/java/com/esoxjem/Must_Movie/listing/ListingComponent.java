package com.esoxjem.Must_Movie.listing;

import com.esoxjem.Must_Movie.listing.sorting.SortingDialogFragment;
import com.esoxjem.Must_Movie.listing.sorting.SortingModule;

import dagger.Subcomponent;

@ListingScope
@Subcomponent(modules = {ListingModule.class, SortingModule.class})
public interface ListingComponent {
    MoviesListingFragment inject(MoviesListingFragment fragment);

    SortingDialogFragment inject(SortingDialogFragment fragment);
}
