package com.fahim.newsviews.app;

import android.app.Application;

import com.fahim.newsviews.BuildConfig;
import com.fahim.newsviews.di.KoinHelper;

import timber.log.Timber;

import static timber.log.Timber.DebugTree;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new DebugTree());
        }
        KoinHelper.start(this);
    }
}
