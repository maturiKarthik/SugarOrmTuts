package com.example.iosdev.sugarormtuts;

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
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

import java.util.Locale;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by iosdev on 06/04/2018.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTest {




    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void setUp() throws Exception {
        //Before Test case execution
        // Test Simulation for Android
        mActivityRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void test1ChatId() {

        Context context = InstrumentationRegistry.getContext();
        Resources resources = context.getResources();


        // THE BELOW CODE GET's THE CURRENT LANG OF THE DEVICE ..
            Locale currentLocale = new Locale("fr");


            if (currentLocale.equals(Locale.FRENCH)) {
                // click French..
                onView(withId(R.id.name)).perform(typeText("rtre")).check(matches(isDisplayed()));
                onView(withId(R.id.num)).perform(typeText("Maturi fdgdf")).check(matches(isDisplayed()));
                onView(withId(R.id.job)).perform(typeText("Dev erterteOps Txt")).check(matches(isDisplayed()));
                // Performing the text written On Button ..
                onView(withId(R.id.save)).check(matches(withText("enregistrer db")));
                onView(withId(R.id.show)).check(matches(withText("montrer db")));
                onView(withId(R.id.update)).check(matches(withText("màj db")));
                // Performing Click Action .. On UI ..
                onView(withId(R.id.save)).perform(click()).check(matches(isDisplayed()));
                onView(withId(R.id.show)).perform(click()).check(matches(isDisplayed()));
                onView(withId(R.id.update)).perform(click()).check(matches(isDisplayed()));


            } else if (currentLocale.equals(Locale.ENGLISH)){
                // click English
                /**
                 * Code For each Language ..
                 */
                // click French..
                onView(withId(R.id.name)).perform(typeText("rtre")).check(matches(isDisplayed()));
                onView(withId(R.id.num)).perform(typeText("Maturi fdgdf")).check(matches(isDisplayed()));
                onView(withId(R.id.job)).perform(typeText("Dev erterteOps Txt")).check(matches(isDisplayed()));
                // Performing the text written On Button ..
                onView(withId(R.id.save)).check(matches(withText("SAVE DB")));
                onView(withId(R.id.show)).check(matches(withText("SHOW DB")));
                onView(withId(R.id.update)).check(matches(withText("UPDATE DB")));
                // Performing Click Action .. On UI ..
                onView(withId(R.id.save)).perform(click()).check(matches(isDisplayed()));
                onView(withId(R.id.show)).perform(click()).check(matches(isDisplayed()));
                onView(withId(R.id.update)).perform(click()).check(matches(isDisplayed()));
            }


    }





    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}