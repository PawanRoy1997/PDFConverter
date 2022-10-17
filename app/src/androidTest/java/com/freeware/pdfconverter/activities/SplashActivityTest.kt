package com.freeware.pdfconverter.activities

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SplashActivityTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(SplashActivity::class.java)

    @Test
    fun seeIfActivityOpens(){
        onView(withText("Splash Screen")).check(matches(isDisplayed()))
    }

    @Test
    fun actionBarShouldBeHidden(){
        onView(withText("PDFConverter")).check(matches(not(isDisplayed())))
    }
}