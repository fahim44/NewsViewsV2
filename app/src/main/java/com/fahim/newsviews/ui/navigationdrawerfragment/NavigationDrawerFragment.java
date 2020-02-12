package com.fahim.newsviews.ui.navigationdrawerfragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.fahim.newsviews.R;
import com.fahim.newsviews.ui.base.BaseFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class NavigationDrawerFragment extends BaseFragment {

    private static final int EXIT_MENU_ITEM_INDEX = 2;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;


    private NavController navController;
    private Set<Integer> topLevelDestinations;

    private OnBackPressedDispatcher dispatcher;
    private OnBackPressedCallback callback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpTopLevelDestinations();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpNestedNavGraph(view);
    }


    private void setUpNestedNavGraph(@NonNull View view) {
        navController = Navigation.findNavController(view.findViewById(R.id.fragmentHolder));
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations).setDrawerLayout(drawer).build();
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        onDrawerItemClickListener();
        onBackPressCallbackSetUp();
    }

    private void setUpTopLevelDestinations() {
        topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.homeFragment);
        topLevelDestinations.add(R.id.aboutFragment);
    }

    private void onBackPressCallbackSetUp() {
        dispatcher = requireActivity().getOnBackPressedDispatcher();
        callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(drawer.isDrawerOpen(GravityCompat.START)){
                    drawer.closeDrawer(GravityCompat.START);
                } else if (!navController.popBackStack()) {
                    disableDispatcherCallbackAndCallOnBackPressed();
                }
            }
        };
        dispatcher.addCallback(this, callback);
    }

    private void onDrawerItemClickListener(){
        navigationView.getMenu().getItem(EXIT_MENU_ITEM_INDEX).setOnMenuItemClickListener(item -> {
            disableDispatcherCallbackAndCallOnBackPressed();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void disableDispatcherCallbackAndCallOnBackPressed(){
        Timber.d("call main graph's onBackPressed");
        callback.setEnabled(false);
        dispatcher.onBackPressed();
    }
}
