package com.example.git1.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private Context context;

    public MainModule(Context context) {

        this.context = context;

    }

    @Provides
    Context provideContext(){

        return context;
    }
}
