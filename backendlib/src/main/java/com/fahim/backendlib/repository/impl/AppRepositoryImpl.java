package com.fahim.backendlib.repository.impl;

import com.fahim.backendlib.datasource.base.SharedPreferenceDataSource;
import com.fahim.backendlib.repository.base.AppRepository;

public class AppRepositoryImpl implements AppRepository {

    private SharedPreferenceDataSource preferenceDataSource;

    public AppRepositoryImpl(SharedPreferenceDataSource preferenceDataSource) {
        this.preferenceDataSource = preferenceDataSource;
    }

    @Override
    public boolean isTutorialPageShown() {
        return preferenceDataSource.isTutorialShown();
    }

    @Override
    public void setTutorialPageAsShown() {
        preferenceDataSource.setTutorialShown(true);
    }
}
