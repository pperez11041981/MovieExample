package com.example.git1.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();

}
