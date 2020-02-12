package com.fahim.newsviews.ui.splashscreenfragment;


import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.fragment.NavHostFragment;

import com.fahim.newsviews.R;
import com.fahim.newsviews.ui.base.BaseFragment;

public class SplashScreenFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(
                () -> NavHostFragment.findNavController(this).navigate(
                        SplashScreenFragmentDirections.actionSplashScreenFragmentToNavigationDrawerFragment()),
                1000);
    }
}
