package com.esoxjem.Must_Movie.details;

import com.esoxjem.Must_Movie.Review;
import com.esoxjem.Must_Movie.ReviewsWrapper;
import com.esoxjem.Must_Movie.Video;
import com.esoxjem.Must_Movie.VideoWrapper;
import com.esoxjem.Must_Movie.network.TmdbWebService;

import java.util.List;

import io.reactivex.Observable;

class MovieDetailsInteractorImpl implements MovieDetailsInteractor {

    private TmdbWebService tmdbWebService;

    MovieDetailsInteractorImpl(TmdbWebService tmdbWebService) {
        this.tmdbWebService = tmdbWebService;
    }

    @Override
    public Observable<List<Video>> getTrailers(final String id) {
        return tmdbWebService.trailers(id).map(VideoWrapper::getVideos);
    }

    @Override
    public Observable<List<Review>> getReviews(final String id) {
        return tmdbWebService.reviews(id).map(ReviewsWrapper::getReviews);
    }

}
