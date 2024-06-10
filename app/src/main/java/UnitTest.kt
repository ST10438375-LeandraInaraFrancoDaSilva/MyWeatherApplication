// MainActivity2Test.kt
package com.example.yourapp

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.not
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivity2Test {

    @Test
    fun testAddData() {
        // Launch the activity
        ActivityScenario.launch(MainActivity2::class.java)

        // Input data into EditTexts
        onView(withId(R.id.dayEditText)).perform(typeText("Monday"), closeSoftKeyboard())
        onView(withId(R.id.minTempEditText)).perform(typeText("20"), closeSoftKeyboard())
        onView(withId(R.id.maxTempEditText)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.weatherCondEditText)).perform(typeText("Sunny"), closeSoftKeyboard())

        // Click the add button
        onView(withId(R.id.addButton)).perform(click())

        // Check if the fields are cleared
        onView(withId(R.id.dayEditText)).check(matches(withText("")))
        onView(withId(R.id.minTempEditText)).check(matches(withText("")))
        onView(withId(R.id.maxTempEditText)).check(matches(withText("")))
        onView(withId(R.id.weatherCondEditText)).check(matches(withText("")))

        // Check if the Toast message is displayed
        onView(withText("Information added successfully"))
            .inRoot(withDecorView(not(withId(android.R.id.content))))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testClearData() {
        // Launch the activity
        ActivityScenario.launch(MainActivity2::class.java)

        // Input data into EditTexts
        onView(withId(R.id.dayEditText)).perform(typeText("Monday"), closeSoftKeyboard())
        onView(withId(R.id.minTempEditText)).perform(typeText("20"), closeSoftKeyboard())
        onView(withId(R.id.maxTempEditText)).perform(typeText("30"), closeSoftKeyboard())
        onView(withId(R.id.weatherCondEditText)).perform(typeText("Sunny"), closeSoftKeyboard())

        // Click the clear button
        onView(withId(R.id.clearButton)).perform(click())

        // Check if the fields are cleared
        onView(withId(R.id.dayEditText)).check(matches(withText("")))
        onView(withId(R.id.minTempEditText)).check(matches(withText("")))
        onView(withId(R.id.maxTempEditText)).check(matches(withText("")))
        onView(withId(R.id.weatherCondEditText)).check(matches(withText("")))

        // Check if the Toast message is displayed
        onView(withText("Information cleared"))
            .inRoot(withDecorView(not(withId(android.R.id.content))))
            .check(matches(isDisplayed()))
    }
}
