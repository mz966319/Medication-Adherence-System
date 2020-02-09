package com.example.mas;

public class DosageValidator {
    private String dosage;

    public DosageValidator(String d){

        dosage = d;
    }

    //Check to see whether email is valid
    public boolean valideDrug(){
        return !(dosage.isEmpty()|| dosage.charAt(0)==' '|| dosage.charAt(dosage.length()-1)==' ');
    }
}
