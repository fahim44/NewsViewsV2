package com.fahim.backendlib.datasource.impl;

import android.content.Context;
import android.content.SharedPreferences;

import com.fahim.backendlib.datasource.base.SharedPreferenceDataSource;

public class SharedPreferenceDataSourceImpl implements SharedPreferenceDataSource {

    private static final String PREFERENCE_KEY = "newsViewsPreference";
    private static final String TUTORIAL_SHOWN = "TUTORIAL_SHOWN";


    private SharedPreferences preferences;

    public SharedPreferenceDataSourceImpl(Context context) {
        preferences = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    @Override
    public boolean isTutorialShown() {
        return preferences.getBoolean(TUTORIAL_SHOWN, false);
    }

    @Override
    public void setTutorialShown(boolean value) {
        preferences.edit().putBoolean(TUTORIAL_SHOWN, value).apply();
    }
}
