package com.example.git1.di;


import com.example.git1.view.MainActivity;

import dagger.Component;

@Component(modules = {NetworkModule.class, MainModule.class})
public interface MainComponent {
    void inject(MainActivity target);
}
