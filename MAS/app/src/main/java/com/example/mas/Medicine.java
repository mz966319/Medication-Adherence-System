package com.example.mas;
/**
 /**
 *<h1>medicine</h1>
 *
 * This class is used to create classes
 *
 * @author Vivian Gao
 * @version 1.0
 * @since 2020-03-20
 */

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
