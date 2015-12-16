package com.riczy.carless.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * A user account of carless.
 */
public class Account implements Serializable {

    @SerializedName("_id")
    private String id;
    private Settings settings;

    /**
     * <p>
     * A string that uniquely identifies this account.
     * </p>
     *
     * @return  The string that uniquely identifies this account.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * <p>
     * The configured settings of the user account.
     * </p>
     *
     * @return  The configured settings of the user account.
     */
    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
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
