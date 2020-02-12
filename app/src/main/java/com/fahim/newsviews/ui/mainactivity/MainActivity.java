package com.fahim.newsviews.ui.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.fahim.newsviews.R;
import com.fahim.newsviews.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        handleLiveData();
    }


    private void handleLiveData() {
        viewModel.getNavDirections().observe(this, navDirections -> navController.navigate(navDirections));
    }
}
