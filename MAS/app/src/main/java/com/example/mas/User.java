package com.example.mas;

public class User {
    private String username;
    private String password;
    private String fullname;

    public User(){}
    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }
    public User(String username){
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullname) { this.fullname = fullname; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullname;
    }
    public String toString(){
        return username + " "+password;
    }
    public boolean username_Empty_Validate() {
        boolean result = true;

        //if the username is all space
        int count = 0;
        for(int i=0;i<username.length();i++){
            if(username.charAt(i)==' '){
                count++;
            }
        }
        if(count == username.length()){
            result = false;
        }

        //if the user name is ''
        if(username.equals("")) result = false;
        if(username.isEmpty()) result = false;

        return (result);
    }

    public boolean password_Empty_Validate() {
        boolean result = true;
        //if the password is all space

        int count = 0;
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)==' '){
                count++;
            }
        }
        if(count == password.length()){
            result = false;
        }

        //if the password is ''
        if(password.equals("")) result = false;
        if (password.isEmpty()) result = false;
        return (result);
    }

    public boolean fullname_Empty_Validate() {
        boolean result = true;
        //if the fullname is all space
        int count = 0;
        for(int i=0;i<fullname.length();i++){
            if(fullname.charAt(i)==' '){
                count++;
            }
        }
        if(count == fullname.length()){
            result = false;
        }

        //if the fullname is ''
        if(fullname.equals("")) result = false;
        if (fullname.isEmpty()) result = false;
        return (result);
    }

    /*public int compareTo(User u) {
        return Integer.compare(this.username, u.getUsername());
    }*/

    /*public boolean usernameIsEmpty() {
        return this.username.equals("");
    }

    public boolean passwordIsEmpty() {
        return this.password.equals("");
    }

    public boolean fullnameIsEmpty() {
        return this.fullname.equals("");
    }

    */
}