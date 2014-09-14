package com.medmanagerui.models;

/**
 * Created by gsayers on 14/09/2014.
 */
public class Bed {

    public String id;

    public Ward ward;

    public boolean isOccupied;

    public String getWardName() {
        return this.ward.name;
    }

}
