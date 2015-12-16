package com.riczy.carless.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test cases for the Trip class.
 */
public class TripTest {

    /**
     * Tests that when the instance is formatted to JSON the id attribute is
     * renamed to "_id" in the resulting JSON string.
     */
    @Test
    public void toString_IdNameShouldChange() {

        Trip t = new Trip();
        t.setId("123456789");
        String tJson = t.toJson();

        Pattern p = Pattern.compile("_id");
        Matcher m = p.matcher(tJson);
        boolean wasFound = m.find();

        System.out.println(tJson);
        assertTrue(wasFound);
    }

}
