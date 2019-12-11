package com.example.git1.presenter;


import com.example.git1.base.BasePresenter;
import com.example.git1.view.MainActivityView;

public interface MainActivityPresenter extends BasePresenter<MainActivityView> {
    void attachView(MainActivityView view);

    void detachView();

    void fetchData();
        }
