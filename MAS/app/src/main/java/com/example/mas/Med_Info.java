package com.example.medicalproject;

public class Med_Info {
    private String medName;
    private String medInfo;

    public Med_Info(String medName, String medInfo) {
        this.medName = medName;
        this.medInfo = medInfo;
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public String getMedInfo() {
        return medInfo;
    }

    public void setMedInfo(String medInfo) {
        this.medInfo = medInfo;
    }
    /**/

}
