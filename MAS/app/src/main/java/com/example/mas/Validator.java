package com.example.mas;

import java.util.ArrayList;

public class Validator {

    private String password;

    public Validator(String p){

        password = p;
    }
    public String getPassword(){

        return password;
    }

    //Check to see it is not "password" (case insensitive)
    public boolean notPassword(){
        return !"password".equals(password.toLowerCase());
    }

    //Check to see it has at least 8 characters
    public boolean longEnough(){
        return password.length()>= 8;
    }

    //check if the password has at least one special character in the provided list
    public boolean specialChar(){
        ArrayList<Character> charList = new ArrayList<>();
        char[] chars = {'~','!','@','#','$','%','^','&','*'};

        for(int i = 0; i < chars.length; i++){
            charList.add(chars[i]);
        }
        for (int i = 0; i < password.length(); i++) {
            if(charList.contains(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    //Check if the password contains at least one digit
    public boolean containDigit(){
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i)>= '0' && password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }
    //Check if the password contains both an upper letter and a lower case letter
    public boolean containUCLC(){
        boolean upperC = false, lowerC = false;
        for (int i = 0; i < password.length(); i++) {
            if(password.charAt(i)>= 'A' && password.charAt(i) <= 'Z') {
                upperC = true;
            }
            if(password.charAt(i)>= 'a' && password.charAt(i) <= 'z') {
                lowerC = true;
            }
        }
        return upperC && lowerC;

    }

    //Implement a validate method that returns the number of rules the string passed
    public int validate(){
        int count = 0;
        if(notPassword()) count++;
        if(longEnough()) count++;
        if(specialChar()) count++;
        if(containDigit()) count++;
        if(containUCLC()) count++;
        return count;
    }
}