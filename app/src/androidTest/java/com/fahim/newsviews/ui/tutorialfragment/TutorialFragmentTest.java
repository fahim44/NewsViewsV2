package com.fahim.newsviews.ui.tutorialfragment;

import android.content.Context;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.fahim.newsviews.R;
import com.google.common.truth.Truth;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class TutorialFragmentTest {

    private FragmentScenario<TutorialFragment> scenario;
    private Context appContext;
    private TestNavHostController navController;

    @Before
    public void setUp() {
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        navController = new TestNavHostController(
                ApplicationProvider.getApplicationContext());
        navController.setGraph(R.navigation.main_nav_graph);
        scenario = FragmentScenario.launchInContainer(TutorialFragment.class);
        scenario.onFragment(fragment -> Navigation.setViewNavController(fragment.requireView(), navController));
    }

    @Test
    public void testNextButtonClick() {
        // check initialPage text, should be developer's name
        onView(Matchers.allOf(isDisplayed(), withId(R.id.textView)))
                .check(matches(withText(appContext.getString(R.string.tutorial_first_page))));

        //perform next button click
        onView(withId(R.id.nextButton))
                .perform(ViewActions.click());

        //check text, should be app name
        onView(Matchers.allOf(isDisplayed(), withId(R.id.textView)))
                .check(matches(withText(appContext.getString(R.string.app_name))));

        //perform next button click
        onView(withId(R.id.nextButton))
                .perform(ViewActions.click());

        //check text, should be developer's position
        onView(Matchers.allOf(isDisplayed(), withId(R.id.textView)))
                .check(matches(withText(appContext.getString(R.string.tutorial_third_page))));

        //next button should be hidden
        onView(withId(R.id.nextButton)).check(matches(Matchers.not(isDisplayed())));
    }

    @Test
    public void testSkipButtonClick() {
        // check initialPage text, should be developer's name
        onView(Matchers.allOf(isDisplayed(), withId(R.id.textView)))
                .check(matches(withText(appContext.getString(R.string.tutorial_first_page))));

        //perform skip button click
        onView(withId(R.id.skipButton))
                .perform(ViewActions.click());


        //check text, should be developer's position
        onView(Matchers.allOf(isDisplayed(), withId(R.id.textView)))
                .check(matches(withText(appContext.getString(R.string.tutorial_third_page))));

        //skip button should be hidden
        onView(withId(R.id.skipButton)).check(matches(Matchers.not(isDisplayed())));
    }

    @Test
    public void testGetStartedButtonClick() {
        //perform skip button click
        onView(withId(R.id.skipButton))
                .perform(ViewActions.click());

        //getStarted button should be shown
        onView(withId(R.id.getStartedTextView)).check(matches(isDisplayed()));

        //perform getStarted button click
        onView(withId(R.id.getStartedTextView))
                .perform(ViewActions.click());

        //navController destination should be NavigationDrawerFragment
        Truth.assertThat(navController.getCurrentDestination().getId()).isEqualTo(R.id.navigationDrawerFragment);
    }
}
