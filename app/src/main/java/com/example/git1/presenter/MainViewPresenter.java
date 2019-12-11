package com.example.git1.presenter;


import com.example.git1.entity.NowPlayingMovieResult;
import com.example.git1.network.NowPlayingMovieAPI;
import com.example.git1.view.MainActivityView;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.git1.utils.Constant.MOVIEDB_API_KEY;

public class MainViewPresenter implements MainActivityPresenter {

    private MainActivityView view;
    private NowPlayingMovieAPI nowPlayingMovieAPI;


    @Inject
    public MainViewPresenter(NowPlayingMovieAPI nowPlayingMovieAPI) {
        this.nowPlayingMovieAPI = nowPlayingMovieAPI;
    }



    @Override
    public void attachView(MainActivityView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void fetchData() {

        Map<String, String> opt = new HashMap<>();
        opt.put("api_key", MOVIEDB_API_KEY);
        opt.put("language", "en-US");
        opt.put("page", "1");

        view.showProgressBar();
        nowPlayingMovieAPI.getNowPlayingMovie(opt).enqueue(new Callback<NowPlayingMovieResult>() {
            @Override
            public void onResponse(Call<NowPlayingMovieResult> call, Response<NowPlayingMovieResult> response) {
                if (response.body() != null) {
                    view.showData(response.body().getMovies());
                }
                view.hideProgressBar();
            }

            @Override
            public void onFailure(Call<NowPlayingMovieResult> call, Throwable t) {
                view.hideProgressBar();
                //show error
            }
        });
    }
}
