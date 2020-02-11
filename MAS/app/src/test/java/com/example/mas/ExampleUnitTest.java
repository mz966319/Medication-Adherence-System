package com.example.mas;

import android.widget.EditText;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void Username_Empty_ValidationTest(){
        User user1 = new User("","testp1", "fn1");
        User user2 = new User("testu2", "testp2", "fn2");
        assertFalse(user1.username_Empty_Validate());
        assertTrue(user2.username_Empty_Validate());
    }

    @Test
    public void Password_Empty_ValidationTest(){
        User user1 = new User("testu1","", "fn1");
        User user2 = new User("testu2", "testp2","fn2");
        assertFalse(user1.password_Empty_Validate());
        assertTrue(user2.password_Empty_Validate());
    }

    @Test
    public void Fullname_Empty_ValidationTest() {
        User user1 = new User("testu1", "testp1", "");
        User user2 = new User("testu2", "testp2", "testfn2");
        assertFalse(user1.fullname_Empty_Validate());
        assertTrue(user2.fullname_Empty_Validate());
    }
}