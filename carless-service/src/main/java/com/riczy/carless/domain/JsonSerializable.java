package com.riczy.carless.domain;

/**
 * <p>
 * Indicates that the class can serialize itself into a JSON format.
 * </p>
 */
public interface JsonSerializable {

    public String toJson();
}
