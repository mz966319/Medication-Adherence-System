package com.example.mas;

public class MedicineForPatient extends Medicine {
    //private String patientName;
    private String doctorname;
    private String totalDosage;
    private String frequency;

    public MedicineForPatient(String drugName, String dosage, String doctorname, String totalDosage, String frequency) {
        super(drugName,dosage);
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
