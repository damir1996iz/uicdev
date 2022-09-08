package com.damikkg.uicjetpackcompose

import android.app.PendingIntent.getActivity
import android.service.autofill.Validators.not
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.damikkg.uicjetpackcompose.ui.fragments.FirstFragment
import com.damikkg.uicjetpackcompose.ui.fragments.FragmentsActivity
import com.damikkg.uicjetpackcompose.ui.fragments.SecondFragment
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.Matchers.not

@RunWith(AndroidJUnit4::class)
class SecondFragmentInstrumentedTest {

    @Before
    fun setUp() {
        launchFragmentInContainer<SecondFragment>()
    }

    @Test
    fun toastBtnClicked() {
        onView(withId(R.id.showToastBtn))
            .perform(click())
    }

    @Test
    fun dialogBtnClicked() {
        onView(withId(R.id.showDialogBtn))
            .perform(click())

        Thread.sleep(1000)

        onView(withText(R.string.dialog_text))
            .check(matches(isDisplayed()))
    }
}
