package com.berlin.htw.blackjack;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.fragment.app.testing.FragmentScenario;

import com.berlin.htw.blackjack.gui.ChooseGameFragment;

import org.junit.Test;

/**
 * The type Choose game fragment test.
 */
public class ChooseGameFragmentTest {
    /**
     * Test fragment launch.
     */
    @Test
    public void testFragmentLaunch() {
        FragmentScenario.launchInContainer(ChooseGameFragment.class);
        onView(withId(R.id.choose_game)).check(matches(isDisplayed()));
    }

    /**
     * Test radio button click.
     */
    @Test
    public void testRadioButtonClick() {
        FragmentScenario.launchInContainer(ChooseGameFragment.class);
        onView(withId(R.id.radioStartSoloGame)).perform(click());
    }
}
