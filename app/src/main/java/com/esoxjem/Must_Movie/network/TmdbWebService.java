package com.esoxjem.Must_Movie.network;

import com.esoxjem.Must_Movie.MoviesWraper;
import com.esoxjem.Must_Movie.ReviewsWrapper;
import com.esoxjem.Must_Movie.VideoWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbWebService {

    @GET("3/discover/movie?language=en&sort_by=popularity.desc")
    Observable<MoviesWraper> popularMovies(@Query("page") int page);

    @GET("3/discover/movie?vote_count.gte=500&language=en&sort_by=vote_average.desc")
    Observable<MoviesWraper> highestRatedMovies(@Query("page") int page);

    @GET("3/discover/movie?language=en&sort_by=release_date.desc")
    Observable<MoviesWraper> newestMovies(@Query("release_date.lte") String maxReleaseDate, @Query("vote_count.gte") int minVoteCount);

    @GET("3/movie/{movieId}/videos")
    Observable<VideoWrapper> trailers(@Path("movieId") String movieId);

    @GET("3/movie/{movieId}/reviews")
    Observable<ReviewsWrapper> reviews(@Path("movieId") String movieId);

    @GET("3/search/movie?language=en-US&page=1")
    Observable<MoviesWraper> searchMovies(@Query("query") String searchQuery);

}
