package com.esoxjem.Must_Movie.details;

import com.esoxjem.Must_Movie.Review;
import com.esoxjem.Must_Movie.Video;

import java.util.List;

import io.reactivex.Observable;

public interface MovieDetailsInteractor {
    Observable<List<Video>> getTrailers(String id);

    Observable<List<Review>> getReviews(String id);
}
