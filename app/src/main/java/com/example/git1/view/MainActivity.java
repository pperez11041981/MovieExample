package com.example.git1.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_movies_now_playing.R;
import com.example.mvp_movies_now_playing.adapter.RVAdapter;
import com.example.mvp_movies_now_playing.di.DaggerMainComponent;
import com.example.mvp_movies_now_playing.di.MainModule;
import com.example.mvp_movies_now_playing.di.NetworkModule;
import com.example.mvp_movies_now_playing.entity.Movie;
import com.example.mvp_movies_now_playing.presenter.MainActivityPresenter;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Inject
    MainActivityPresenter presenter;

    //recyclerView, adapter
    RecyclerView recyclerView;
    @Inject
    RVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerMainComponent
                .builder()
                .networkModule(new NetworkModule())
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        presenter.attachView(this);

        //initialize  all views
        recyclerView = findViewById(R.id.rv_now_playing);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
        //ask to presenter for data

        presenter.fetchData();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }


    @Override
    public void showData(List<Movie> movies) {
        //I got it the list, setup adapter and notify all
        adapter.setList(movies);
    }
}
