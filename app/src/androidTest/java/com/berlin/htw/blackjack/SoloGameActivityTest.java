package com.berlin.htw.blackjack;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.berlin.htw.blackjack.gui.SoloGameActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * The type Solo game activity test.
 */
@RunWith(AndroidJUnit4.class)
public class SoloGameActivityTest {

    /**
     * The Activity rule.
     */
    @Rule
    public ActivityScenarioRule<SoloGameActivity> activityRule =
            new ActivityScenarioRule<>(SoloGameActivity.class);

    /**
     * Test activity launch.
     */
    @Test
    public void testActivityLaunch() {
        onView(withId(R.id.solo_game)).check(matches(isDisplayed()));
    }

    /**
     * Test place bet.
     */
    @Test
    public void testPlaceBet() {
        onView(withId(R.id.etBetAmount)).perform(typeText("5"));
        onView(withId(R.id.btnPlaceBet)).perform(click());
    }

    /**
     * Test hit button.
     */
    @Test
    public void testHitButton() {
        onView(withId(R.id.btnHit)).perform(click());
        onView(withId(R.id.playerHandContainer)).check(matches(isDisplayed()));
    }

    /**
     * Test stand button.
     */
    @Test
    public void testStandButton() {
        onView(withId(R.id.btnStand)).perform(click());
        onView(withId(R.id.dealerHandContainer)).check(matches(isDisplayed()));
    }

    /**
     * Test reset button.
     */
    @Test
    public void testResetButton() {
        onView(withId(R.id.btnReset)).perform(click());
        onView(withId(R.id.playerHandContainer)).check(matches(isDisplayed()));
    }
}
