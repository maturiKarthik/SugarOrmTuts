package com.example.iosdev.sugarormtuts;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by iosdev on 06/04/2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void setUp() throws Exception {
        //Before Test case execution
        // Test Simulation for Android
        mActivityRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void test1ChatId() {
        // TEST_CASES_FOR_ACTIVITY ..
        onView(withId(R.id.name)).perform(typeText("rtre")).check(matches(isDisplayed()));
        onView(withId(R.id.num)).perform(typeText("Maturi fdgdf")).check(matches(isDisplayed()));
        onView(withId(R.id.job)).perform(typeText("Dev erterteOps Txt")).check(matches(isDisplayed()));
        onView(withId(R.id.save)).perform(click()).check(matches(isDisplayed()));

        onView(withId(R.id.show)).perform(click()).check(matches(isDisplayed()));

    }

    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}