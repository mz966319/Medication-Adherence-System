package com.example.mas;

import java.time.LocalDate;

public class MedRecord {
    String username;
    String med_name;
    LocalDate date;

    public MedRecord(String username, String med_name, LocalDate date) {
        this.username = username;
        this.med_name = med_name;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}