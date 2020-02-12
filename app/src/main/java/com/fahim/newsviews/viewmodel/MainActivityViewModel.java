package com.fahim.newsviews.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;

import com.fahim.backendlib.repository.base.AppRepository;
import com.fahim.newsviews.MainNavGraphDirections;

import static org.koin.java.KoinJavaComponent.inject;

import kotlin.Lazy;
import timber.log.Timber;

public class MainActivityViewModel extends AndroidViewModel {

    private Lazy<AppRepository> appRepositoryLazy = inject(AppRepository.class);

    private MutableLiveData<NavDirections> navDirectionsLD = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        checkAndNavigateToSplashScreen();
    }

    public LiveData<NavDirections> getNavDirections() {
        return navDirectionsLD;
    }

    private void checkAndNavigateToSplashScreen() {
        if (appRepositoryLazy.getValue().isTutorialPageShown()) {
            Timber.d("Tutorial Page already shown");
            navDirectionsLD.setValue(MainNavGraphDirections.actionGlobalSplashScreenFragment());
        } else {
            Timber.d("Set Tutorial Page to shown");
            appRepositoryLazy.getValue().setTutorialPageAsShown();
        }
    }
}
