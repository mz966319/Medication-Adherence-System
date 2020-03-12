package com.example.mas;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class RegistrationTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);
    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void testFullName(){
        onView(withId(R.id.ETFullname))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(" "));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETUsername))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("aa"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("aa"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.BtnRegister))
                .perform(click());
        onView(withId(R.id.regEError))
                .check(matches(withText("Empty full name!")));
    }
    @Test
    public void testUserName(){
        onView(withId(R.id.ETFullname))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("aa"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETUsername))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("aa"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.BtnRegister))
                .perform(click());
        onView(withId(R.id.regEError))
                .check(matches(withText("Empty username!")));
    }
    @Test
    public void testPassword(){
        onView(withId(R.id.ETFullname))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("aa"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETUsername))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText("aa"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.ETPassword))
                .perform(replaceText(""))
                .perform(click())
                .perform(typeText(""));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.BtnRegister))
                .perform(click());
        onView(withId(R.id.regEError))
                .check(matches(withText("Empty password!")));
    }
}