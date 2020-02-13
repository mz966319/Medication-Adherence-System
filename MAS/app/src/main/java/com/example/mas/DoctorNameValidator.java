package com.example.mas;

public class DoctorNameValidator {
    private String doctorName;

    public DoctorNameValidator(String d){

        doctorName = d;
    }

    //Check to see whether email is valid
    public boolean valideDoctor(){
        return !(doctorName.isEmpty()|| doctorName.charAt(0)==' '||!doctorName.matches("[a-zA-Z]+"));
    }
}
