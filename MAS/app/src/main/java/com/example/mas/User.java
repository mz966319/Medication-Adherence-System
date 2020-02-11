package com.example.mas;

public class User {
    public String username;
    public String password;
    public String fullname;

    public User(String u, String p, String fn) {
        username = u;
        password = p;
        fullname = fn;
    }

    public void setUsername(String s) {
        username = s;
    }

    public void setPassword(String s) {
        password = s;
    }

    public void setFullName(String fn) { password = fn; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() { return fullname; }

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

    public boolean fullname_Empty_Validate() {
        if (this.fullname.equals("")) {
            return false;
        } else {
            return true;
        }
    }
}