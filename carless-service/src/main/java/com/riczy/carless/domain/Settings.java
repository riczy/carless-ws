package com.riczy.carless.domain;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * <p>
 * The settings for a carless account.
 * </p>
 */
public class Settings implements Serializable {

    private Vehicle vehicle;
    private String distanceUnitCode;

    /**
     * <p>
     * The default vehicle established by the user to represent the vehicle
     * that is not being used during a carless transportation trip.
     * </p>
     * <p>
     * This vehicle is used to calculate fuel, money, co2 and other savings.
     * </p>
     *
     * @return  The default vehicle established by the user
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * <p>
     * The preferred distance display unit established by the user.
     * </p>
     *
     * @return  The preferred distance display unit.
     */
    public String getDistanceUnitCode() {
        return distanceUnitCode;
    }

    public void setDistanceUnitCode(String distanceUnitCode) {
        this.distanceUnitCode = distanceUnitCode;
    }

    /**
     * <p>The string representation of this instance which will return its JSON
     * representation.
     * </p>
     */
    public String toString() {
        return new Gson().toJson(this);
    }

}
