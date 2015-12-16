package com.riczy.carless.domain;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * Represents a location reading as determined from a GPS device.
 * </p>
 */
public class Waypoint implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date receivedTimestamp;
    private Date timestamp;

    private Double altitude;
    private Double course;
    private Double horizontalAccuracy;
    private Double latitude;
    private Double longitude;
    private Double speed;
    private Double verticalAccuracy;

    /**
     * <p>
     * The date and time that the waypoint was received by the location
     * software.
     * </p>
     * <p>
     * In general, there is threshold where if the difference is too large
     * between the received timestamp and the actual timestamp of the location
     * reading then the waypoint should be discarded.
     * </p>
     *
     * @return  The date and time that the waypoint was received by location
     *          software.
     */
    public Date getReceivedTimestamp() {
        return receivedTimestamp;
    }

    public void setReceivedTimestamp(Date receivedTimestamp) {
        this.receivedTimestamp = receivedTimestamp;
    }

    /**
     * <p>
     * The date and time at which this location was determined.
     * </p>
     *
     * @return  The date and time of this location reading.
     */
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * <p>
     * The altitude of this location measured in meters.
     * </p>
     * <p>
     * A positive value indicates that this altitude is above sea level whereas
     * a negative value indicates that it is below sea level.
     * </p>
     *
     * @return  The
     */
    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    /**
     * <p>
     * The direction in which the device taking the location measurement is
     * travelling.
     * </p>
     * <p>
     * Course values are measured in degrees starting at due north and continuing
     * clockwise around the compass. Thus, north is 0 degrees, east is 90 degrees,
     * south is 180 degrees, and so on.
     * A negative value indicates that the direction is invalid.
     * </p>
     * @return
     */
    public Double getCourse() {
        return course;
    }

    public void setCourse(Double course) {
        this.course = course;
    }

    /**
     * <p>
     * The radius of uncertainty for the location measured in meters.
     * </p>
     * <p>
     * The location’s latitude and longitude identify the center of the circle,
     * and this value indicates the radius of that circle. A negative value
     * indicates that the location’s latitude and longitude are invalid.
     * </p>
     *
     * @return  The radius of uncertainty for the location, measured in
     *          meters
     */
    public Double getHorizontalAccuracy() {
        return horizontalAccuracy;
    }

    public void setHorizontalAccuracy(Double horizontalAccuracy) {
        this.horizontalAccuracy = horizontalAccuracy;
    }

    /**
     * <p>
     * The latitude portion of the geographical coordinate of this location.
     * </p>
     *
     * @return  The latitude of this location's geographical coordinate.
     */
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * <p>
     * The longitude portion of the geographical coordinate of this location.
     * </p>
     *
     * @return  The longitude of this location's geographical coordinate.
     */
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * <p>
     * The instantaneous speed of the device taking the measurement in meters
     * per second.
     * </p>
     * <p>
     * This value reflects the instantaneous speed of the device in the direction
     * of its current heading. A negative value indicates an invalid speed.
     * Because the actual speed can change many times between the delivery of
     * subsequent location events, this property should only be used for
     * informational purposes.
     * </p>
     *
     * @return  The speed of the device measuring the location in meters per second.
     */
    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * <p>
     * The accuracy of the altitude value in meters.
     * </p>
     * <p>
     * The value in the altitude property could be plus or minus the value
     * indicated by this property. A negative value indicates that the
     * altitude value is invalid.
     * </p>
     *
     * @return  The accuracy of the altitude value in meters.
     */
    public Double getVerticalAccuracy() {
        return verticalAccuracy;
    }

    public void setVerticalAccuracy(Double verticalAccuracy) {
        this.verticalAccuracy = verticalAccuracy;
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
