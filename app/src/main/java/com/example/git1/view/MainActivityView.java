package com.example.git1.view;

import com.example.git1.base.BaseView;
import com.example.git1.entity.Movie;

import java.util.List;

public interface MainActivityView extends BaseView {
    void showData(List<Movie> movies);
}
