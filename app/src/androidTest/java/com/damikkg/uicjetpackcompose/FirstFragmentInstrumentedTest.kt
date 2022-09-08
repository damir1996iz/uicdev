package com.damikkg.uicjetpackcompose

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.damikkg.uicjetpackcompose.ui.fragments.FirstFragment
import com.damikkg.uicjetpackcompose.ui.fragments.FragmentsActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FirstFragmentInstrumentedTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(FragmentsActivity::class.java)
    }

    @Test
    fun addClicked() {
        onView(withId(R.id.countUpBtn))
            .perform(click())
        onView(withId(R.id.counter))
            .check(matches(withText("1")))
    }

    @Test
    fun onNavigationClicked() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext())

        val testScenario = launchFragmentInContainer<FirstFragment>()

        testScenario.onFragment {
            navController.setGraph(R.navigation.fragments_navigation)
            Navigation.setViewNavController(it.requireView(), navController)
        }

        onView(withId(R.id.nextScreenBtn))
            .perform(click())

        assert(navController.currentDestination?.id == R.id.secondFragment)
    }

}
