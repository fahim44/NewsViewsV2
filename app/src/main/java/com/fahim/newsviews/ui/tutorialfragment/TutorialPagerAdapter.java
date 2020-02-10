package com.fahim.newsviews.ui.tutorialfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.fahim.newsviews.R;

public class TutorialPagerAdapter extends PagerAdapter {


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.item_viewpager_fragment_tutorial, container, false);
        TextView textView = view.findViewById(R.id.textView);
        setUpText(textView, position);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    private void setUpText(TextView textView, int position) {
        switch (position) {
            case 0:
                textView.setText(R.string.tutorial_first_page);
                break;
            case 1:
                textView.setText(R.string.app_name);
                break;
            default:
                textView.setText(R.string.tutorial_third_page);
        }
    }
}
