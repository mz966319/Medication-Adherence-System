package com.example.mas;

public class DrugNameValidator {

    private String drugName;

    public DrugNameValidator(String d){

        drugName = d;
    }

    //Check to see whether email is valid
    public boolean valideDrug(){
        return !(drugName.isEmpty()|| drugName.charAt(0)==' '||!(drugName.matches(".*[a-zA-Z]+.*")));
    }
}