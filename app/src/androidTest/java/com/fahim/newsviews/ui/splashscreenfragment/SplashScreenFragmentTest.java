package com.fahim.newsviews.ui.splashscreenfragment;

import android.content.Context;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.fahim.newsviews.R;

import org.hamcrest.core.AllOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SplashScreenFragmentTest {
    private FragmentScenario<SplashScreenFragment> scenario;
    private Context appContext;

    @Before
    public void setUp() {
        scenario = FragmentScenario.launchInContainer(SplashScreenFragment.class);
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @Test
    public void testSplashScreen() {
        // check view is shown
        Espresso.onView(AllOf.allOf(
                ViewMatchers.withId(R.id.textView),
                ViewMatchers.withText(appContext.getString(R.string.app_name))
        )).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
