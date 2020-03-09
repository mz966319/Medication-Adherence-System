package com.example.mas;

public class TotalDosageValidator {
    private String totalDosage;

    public TotalDosageValidator(String t){

        totalDosage = t;
    }

    //Check to see whether email is valid
    public boolean valideTotalDosage(){
        return !(totalDosage.isEmpty()|| totalDosage.charAt(0)==' '||!(totalDosage.matches("^\\d+$")));
}
}
