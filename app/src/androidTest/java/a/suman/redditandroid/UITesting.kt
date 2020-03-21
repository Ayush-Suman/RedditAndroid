package a.suman.redditandroid

import a.suman.redditandroid.View.MainActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isFocusable
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class UITesting {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun TestRefreshButton(){
        onView(withId(R.id.imageView)).perform(click())
        onView(withId(R.id.imageView)).check(matches(isFocusable()))
    }

}
