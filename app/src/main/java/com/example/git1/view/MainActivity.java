package com.example.git1.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.git1.R;
import com.example.git1.adapter.RVAdapter;
import com.example.git1.di.DaggerMainComponent;
import com.example.git1.di.MainModule;
import com.example.git1.di.NetworkModule;
import com.example.git1.entity.Movie;
import com.example.git1.presenter.MainActivityPresenter;

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
