package com.example.git1.presenter;


import com.example.mvp_movies_now_playing.base.BasePresenter;
import com.example.mvp_movies_now_playing.view.MainActivityView;

public interface MainActivityPresenter extends BasePresenter<MainActivityView> {
    void attachView(MainActivityView view);

    void detachView();

    void fetchData();
        }
