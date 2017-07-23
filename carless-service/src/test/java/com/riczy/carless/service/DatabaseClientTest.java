package com.riczy.carless.service;

import com.google.gson.Gson;
import com.riczy.carless.domain.Trip;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class DatabaseClientTest {

    @Test
    public void toObject_ArrayOfObjects() {

        Trip trip1 = new Trip();
        trip1.setAccountId("0001");
        trip1.setId("0000000001A");
        trip1.setDistance(5.1);
        trip1.setStartTimestamp(new Date());

        Trip trip2 = new Trip();
        trip2.setAccountId("0001");
        trip2.setId("0000000001B");
        trip2.setDistance(3.1);
        trip2.setStartTimestamp(new Date());

        ArrayList<Trip> trips = new ArrayList<>();
        trips.add(trip1);
        trips.add(trip2);

        System.out.println("-----------");
        System.out.println(new Gson().toJson(trips));
        System.out.println("-----------");

        Document document = DatabaseClient.toDocument(trips);
        System.out.println(document);
    }
}

