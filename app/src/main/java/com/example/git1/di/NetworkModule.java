package com.example.git1.di;


import android.content.Context;

import com.example.git1.adapter.RVAdapter;
import com.example.git1.network.NowPlayingMovieAPI;
import com.example.git1.presenter.MainActivityPresenter;
import com.example.git1.presenter.MainViewPresenter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    NowPlayingMovieAPI provideNowPlayingAPI(){
        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor LoggingInterceptor = new HttpLoggingInterceptor();
        LoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(LoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        return retrofit.create(NowPlayingMovieAPI.class);
    }

    @Provides
    MainActivityPresenter provideMainActivityPresenter(NowPlayingMovieAPI nowPlayingMovieAPI){
        return new MainViewPresenter(nowPlayingMovieAPI);
    }


    @Provides
    RVAdapter provideRVAdapter(Context context){
        return new RVAdapter(context);
    }
}
