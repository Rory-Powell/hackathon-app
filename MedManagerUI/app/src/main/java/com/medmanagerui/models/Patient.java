package com.medmanagerui.models;

import java.util.Calendar;

public class Patient {

    private String id;

    private String name;

    private long dob;

    private String address;

    private String gp;

    private String doctorId;

    private String previousDocId;

    private String ailment;

    private String allergies;

    private String notes;

    private int bed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDob() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dob);
        return calendar;
    }

    public void setDob(Calendar dob) {

        this.dob = dob.getTimeInMillis();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPreviousDocId() {
        return previousDocId;
    }

    public void setPreviousDocId(String previousDocId) {
        this.previousDocId = previousDocId;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
}
