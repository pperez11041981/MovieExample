package com.example.git1.view;

import com.example.mvp_movies_now_playing.base.BaseView;
import com.example.mvp_movies_now_playing.entity.Movie;

import java.util.List;

public interface MainActivityView extends BaseView {
    void showData(List<Movie> movies);
}
