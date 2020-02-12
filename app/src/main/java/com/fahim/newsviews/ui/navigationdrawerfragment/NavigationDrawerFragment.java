package com.fahim.newsviews.ui.navigationdrawerfragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fahim.newsviews.R;
import com.fahim.newsviews.ui.base.BaseFragment;

public class NavigationDrawerFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }

}
