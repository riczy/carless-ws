package com.riczy.carless.domain;

import com.google.gson.Gson;

/**
 * <p>
 * Represents market available vehicle along with fuel efficiency values as
 * provided by the US EPA.
 * </p>
 */
public class Vehicle {

    private String atvType;
    private Integer comb08;
    private Double comb08U;
    private Integer combA08;
    private Double combA08U;
    private String epaVehicleId;
    private String make;
    private String model;
    private String year;

    public String getAtvType() {
        return atvType;
    }

    public void setAtvType(String atvType) {
        this.atvType = atvType;
    }

    public Integer getComb08() {
        return comb08;
    }

    public void setComb08(Integer comb08) {
        this.comb08 = comb08;
    }

    public Double getComb08U() {
        return comb08U;
    }

    public void setComb08U(Double comb08U) {
        this.comb08U = comb08U;
    }

    public Integer getCombA08() {
        return combA08;
    }

    public void setCombA08(Integer combA08) {
        this.combA08 = combA08;
    }

    public Double getCombA08U() {
        return combA08U;
    }

    public void setCombA08U(Double combA08U) {
        this.combA08U = combA08U;
    }

    public String getEpaVehicleId() {
        return epaVehicleId;
    }

    public void setEpaVehicleId(String epaVehicleId) {
        this.epaVehicleId = epaVehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
