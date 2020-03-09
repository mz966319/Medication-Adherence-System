package com.example.mas;

public class MedicineForPatient extends Medicine {
    //private String patientName;
    private String doctorname;
    private String totalDosage;

    public MedicineForPatient(String drugName,String dosage, String doctorName, String totalDosage) {
        super(drugName,dosage);
        //this.patientName = patientName;
        this.doctorname = doctorName;
        this.totalDosage = totalDosage;
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
}
