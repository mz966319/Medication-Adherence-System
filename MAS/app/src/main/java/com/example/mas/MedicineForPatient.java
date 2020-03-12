package com.example.mas;
/**
 *<h1>medicine</h1>
 *
 * This class is used to create objects for users.
 *
 * @author Moaaaz Baiumy
 * @version 1.0
 * @since 2020-02-26
 */
public class MedicineForPatient extends Medicine {
    //private String patientName;
    private String doctorname;
    private String totalDosage;
    private String frequency;
//    private String drugName;
//    private String dosage;
    public MedicineForPatient(){}
    public MedicineForPatient(String drugName, String dosage, String doctorname, String totalDosage, String frequency) {
        super(drugName,dosage);
//        this.drugName = drugName;
//        this. dosage = dosage;
        //this.patientName = patientName;
        this.doctorname = doctorname;
        this.totalDosage = totalDosage;
        this.frequency = frequency;
    }

//    public String getPatientName() {
//        return patientName;
//    }
//
//    public void setPatientName(String patientName) {
//        this.patientName = patientName;
//    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getTotalDosage() {
        return totalDosage;
    }

    public void setTotalDosage(String totalDosage) {
        this.totalDosage = totalDosage;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
