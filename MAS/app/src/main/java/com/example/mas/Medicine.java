package com.example.mas;

public class Medicine {

    private String drugname;
    private String dosage;
    private String doctorname;
    public Medicine(){}
    public Medicine(String drugname,String dosage, String doctorname){
        this.drugname = drugname;
        this.dosage = dosage;
        this.doctorname = doctorname;
    }
    public String getDrugname() {
        return drugname;
    }

    public void setDrugname(String drugname) {
        this.drugname = drugname;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }
}
