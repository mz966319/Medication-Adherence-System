package com.example.mas;

import java.time.LocalDate;

public class MedRecord {
    String username;
    String med_name;
    String date;
    String dosage;
    boolean takenStatus = false;

    public MedRecord() { }

    public MedRecord(String username, String medname) {
        this.username = username;
        this.med_name = medname;
        this.dosage ="";
        this.date = "2000-00-00";
        this.takenStatus = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMed_name() {
        return med_name;
    }

    public void setMed_name(String med_name) {
        this.med_name = med_name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() { return date; }

    public String getQuantity() { return dosage; }

    public void setQuantity(String quantity) { this.dosage = quantity; }

    public boolean getTakenStatus() { return takenStatus; }

    public void setTakenStatus(boolean takenStatus) { this.takenStatus = takenStatus; }

    @Override
    public String toString() {
        return "[" + username + " : " + med_name + "]  "+ date + " ,  dosage: " + dosage + "    taken? " + takenStatus;
    }
}