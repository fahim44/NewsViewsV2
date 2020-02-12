package com.fahim.newsviews.ui.tutorialfragment;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;

import com.fahim.newsviews.R;
import com.fahim.newsviews.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class TutorialFragment extends BaseFragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.bottomButtonsLayout)
    View bottomButtonsLayout;

    @BindView(R.id.getStartedTextView)
    View getStartedTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.setAdapter(new TutorialPagerAdapter());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (viewPager.getAdapter() != null) {
                    Timber.d("TutorialFragment--> pagerSelectedPosition %s", position);
                    if (position == viewPager.getAdapter().getCount() - 1) {
                        bottomButtonsLayout.setVisibility(View.GONE);
                        getStartedTextView.setVisibility(View.VISIBLE);
                    } else {
                        bottomButtonsLayout.setVisibility(View.VISIBLE);
                        getStartedTextView.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @OnClick(R.id.nextButton)
    void nextButtonClicked() {
        if (viewPager.getAdapter() != null) {
            if (viewPager.getCurrentItem() < viewPager.getAdapter().getCount() - 1)
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    @OnClick(R.id.skipButton)
    void skipButtonClicked() {
        if (viewPager.getAdapter() != null)
            viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 1);
    }

    @OnClick(R.id.getStartedTextView)
    void getStartedButtonClicked() {
        NavHostFragment.findNavController(this).navigate(
                TutorialFragmentDirections.actionTutorialFragmentToNavigationDrawerFragment());
    }

}
