package com.example.git1.network;

import com.example.git1.entity.NowPlayingMovieResult;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface NowPlayingMovieAPI {


    @GET("movie/now_playing")
    Call<NowPlayingMovieResult> getNowPlayingMovie(@QueryMap Map<String, String> options);


}
