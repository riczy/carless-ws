package com.riczy.carless.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * Represents a S.O.V.-less transportation trip that was taken by a user.
 * </p>
 */
public class Trip implements Serializable, JsonSerializable {

    @SerializedName("_id")
    private String id;
    private String accountId;
    private Date startTimestamp;
    private Date endTimestamp;
    private Double distance;
    private BigDecimal fuelPrice;
    private Date fuelPriceDate;
    private String fuelPriceSeriesId;
    private String logTypeCode;
    private String modeTypeCode;
    private Vehicle vehicle;
    private List<Waypoint> waypoints;

    /**
     * <p>
     * A string that uniquely identifies this trip.
     * </p>
     *
     * @return  The unique identifier of this trip.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>
     * The unique id of the user account to which this trip is associated.
     * </p>
     *
     * @return  The unique id of the user account to which this trip is
     *          associated.
     */
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * <p>
     * The date and time when the trip commenced.
     * </p>
     *
     * @return  The date and time when the trip commenced.
     */
    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    /**
     * <p>
     * The date and time when the trip terminated.
     * </p>
     *
     * @return  The date and time when the trip terminated.
     */
    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    /**
     * <p>
     * The distance in meters that was travelled during this trip.
     * </p>
     *
     * @return  The distance in meters that was travelled during this trip.
     */
    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    /**
     * <p>
     * The price of fuel, per gallon, in the market at the time when the trip
     * is started.
     * </p>
     *
     * @return  The price of fuel when this trip is started.
     */
    public BigDecimal getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(BigDecimal fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    public Date getFuelPriceDate() {
        return fuelPriceDate;
    }

    public void setFuelPriceDate(Date fuelPriceDate) {
        this.fuelPriceDate = fuelPriceDate;
    }

    public String getFuelPriceSeriesId() {
        return fuelPriceSeriesId;
    }

    public void setFuelPriceSeriesId(String fuelPriceSeriesId) {
        this.fuelPriceSeriesId = fuelPriceSeriesId;
    }

    public String getLogTypeCode() {
        return logTypeCode;
    }

    public void setLogTypeCode(String logTypeCode) {
        this.logTypeCode = logTypeCode;
    }

    public String getModeTypeCode() {
        return modeTypeCode;
    }

    public void setModeTypeCode(String modeTypeCode) {
        this.modeTypeCode = modeTypeCode;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(List<Waypoint> waypoints) {
        this.waypoints = waypoints;
    }

    /**
     * <p>The string representation of this instance which will return its JSON
     * representation.
     * </p>
     */
    public String toString() {
        return toJson();
    }

    /**
     * <p>
     * Returns this instance as a JSON string.
     * </p>
     *
     * @return  This instance represented as JSON-formatted string.
     */
    @Override
    public String toJson() {
        return new Gson().toJson(this);
    }
}

