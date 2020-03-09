package com.example.mas;

public class Medicine {

    private String drugName;
    private String dosage;
//    private String doctorname;
    public Medicine(){}
    public Medicine(String drugName,String dosage){
        this.drugName = drugName;
        this.dosage = dosage;
//        this.doctorname = doctorname;
    }
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {

        this.dosage = dosage;
    }

//    public String getDoctorname() {
//        return doctorname;
//    }
//
//    public void setDoctorname(String doctorname) {
//        this.doctorname = doctorname;
//    }
}
