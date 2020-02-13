package com.example.mas;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;




public class ValidatorTest {
    @Test
    public void notPasswordTest() {
        Validator v1 = new Validator("Password");
        Validator v2 = new Validator("password");
        Validator v3 = new Validator("Dongding");

        assertFalse(v1.notPassword());
        assertFalse(v2.notPassword());
        assertTrue(v3.notPassword());
    }

    @Test
    public void longEnoughTest(){
        Validator v1 = new Validator("Password");
        Validator v2 = new Validator("abc");
        Validator v3 = new Validator("abcdefghijk");
        Validator v4 = new Validator("");

        assertTrue(v1.longEnough());
        assertFalse(v2.longEnough());
        assertTrue(v3.longEnough());
        assertFalse(v4.longEnough());
    }

    @Test
    public void specialCharTest(){
        Validator v1 = new Validator("Password");
        Validator v2 = new Validator("234dd");
        Validator v3 = new Validator("testpsw123@");
        Validator v4 = new Validator("@#dsff&");

        assertFalse(v1.specialChar());
        assertFalse(v2.specialChar());
        assertTrue(v3.specialChar());
        assertTrue(v4.specialChar());
    }

    @Test
    public void containDigitTest(){
        Validator v1 = new Validator("Password");
        Validator v2 = new Validator("%&^dd");
        Validator v3 = new Validator("testpsw123@");

        assertFalse(v1.containDigit());
        assertFalse(v2.containDigit());
        assertTrue(v3.containDigit());
    }

    @Test
    public void containUCLCTest(){
        Validator v1 = new Validator("password");
        Validator v2 = new Validator("PASSWORD");
        Validator v3 = new Validator("TestPsw");

        assertFalse(v1.containUCLC());
        assertFalse(v2.containUCLC());
        assertTrue(v3.containUCLC());
    }

    @Test
    public void validateTest(){
        Validator v1 = new Validator("Password");
        Validator v2 = new Validator("abc");
        Validator v3 = new Validator("12314efghijk");
        Validator v4 = new Validator("TestPsd123@");

        assertTrue(v1.validate() == 2);
        assertTrue(v2.validate() == 1);
        assertTrue(v3.validate() == 3);
        assertTrue(v4.validate() == 5);
    }
}
