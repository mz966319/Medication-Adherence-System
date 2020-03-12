package com.example.mas;

import android.os.IBinder;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.Root;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testUserNameAndPassword(){
        onView(withId(R.id.ETName))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(""));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(R.id.BtnLogin)).perform(click());
//        onView(withId(R.id.BtnLogin))
//                .perform(click());
        onView(withId(R.id.TVerrors))
                .check(matches(withText("Invalid username or password")));
    }
    @Test
    public void testUserName(){
        onView(withId(R.id.ETName))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.BtnLogin))
                .perform(click());
        onView(withId(R.id.TVerrors))
                .check(matches(withText("Invalid username or password")));
    }
    @Test
    public void testPassword(){
        onView(withId(R.id.ETName))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("user"));
        Espresso.closeSoftKeyboard();
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(""));
        Espresso.closeSoftKeyboard();
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.BtnLogin))
                .perform(click());
        onView(withId(R.id.TVerrors))
                .check(matches(withText("Invalid username or password")));
    }
    @Test
    public void testValidUsernamePassword(){
        onView(withId(R.id.ETName))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("user"));
        Espresso.closeSoftKeyboard();
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("pass"));
        Espresso.closeSoftKeyboard();
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.BtnLogin))
                .perform(click());
        onView(withId(R.id.TVerrors))
                .check(matches(withText("Logged in successfully")));
    }
    @After
    public void tearDown() throws Exception {
    }
}
