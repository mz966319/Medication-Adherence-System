package com.example.mas;

public class User {
    public String username;
    public String password;

    public User(String u, String p) {
        username = u;
        password = p;
    }

    public void setUser(String s) {
        username = s;
    }

    public void setPass(String s) {
        password = s;
    }

    public String getUser() {
        return username;
    }

    public String getPass() {
        return password;
    }

    public boolean username_Empty_Validate() {
        if (this.username.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean password_Empty_Validate() {
        if (this.password.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}