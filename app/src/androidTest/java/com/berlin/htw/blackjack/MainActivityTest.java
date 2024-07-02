package com.berlin.htw.blackjack;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

/**
 * The type Main activity test.
 */
public class MainActivityTest {

    /**
     * The Activity rule.
     */
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Test activity launch.
     */
    @Test
    public void testActivityLaunch() {
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }
}
