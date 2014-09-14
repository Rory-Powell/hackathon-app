package com.medmanagerui.models;

import com.medmanagerui.networking.NetworkingService;

import java.util.Calendar;

import retrofit.Callback;

public class Patient {

    private String id;

    private String name;

    private long dob;

    private String address;

    private String gp;

    private String doctor;

    private String previousDoctor;

    private String ailment;

    private String allergies;

    private String notes;

    private String vaccinations;

    private String medication;

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

    public String getPreviousDoctor() {
        return previousDoctor;
    }

    public void setPreviousDoctor(String doctorId) {
        this.previousDoctor = doctorId;
    }

    public Staff getDoctor() {
        for(Staff staff : DataProvider.staffList) {
            if(staff.id.equals(String.valueOf(this.doctor))){
                return staff;
            }
        }
        return null;
    }

    public void setDoctor(String docId) {
        this.doctor = docId;
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

    public Bed getBed() {
        for(Bed bed : DataProvider.bedList) {
            if(bed.id.equals(String.valueOf(this.bed))){
                return bed;
            }
        }
        return null;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }
    public void save(Callback cb) {
        new NetworkingService().savePatient(this, cb);
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }
}
