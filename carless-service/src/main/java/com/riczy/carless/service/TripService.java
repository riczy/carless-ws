package com.riczy.carless.service;

import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import com.riczy.carless.domain.Trip;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mongodb.client.model.Filters.eq;

/**
 * <p>
 * Provides management for creating and viewing trips for an account.
 * </p>
 */
public class TripService {

    private final static Logger logger = LoggerFactory.getLogger(TripService.class);

    private MongoCollection<Document> collection;

    private MongoCollection<Document> getCollection() {
        if (collection == null) {
            collection = DatabaseClient.getDatabase().getCollection("trip");
        }
        return collection;
    }

    public void save(Trip trip) {

        Document dbObj = DatabaseClient.toDocument(trip);

        if (trip.getId() == null) {
            getCollection().insertOne(dbObj, new SingleResultCallback<Void>() {
                @Override
                public void onResult(Void aVoid, Throwable throwable) {
                    if (throwable != null) {
                        logger.debug("An error occurred when inserting a trip: {}", throwable);
                    } else {
                        logger.debug("Saved successfully.");
                    }
                }
            });
        } else {
            getCollection().updateOne(eq("_id", trip.getId()), dbObj, new SingleResultCallback<UpdateResult>() {
                @Override
                public void onResult(UpdateResult updateResult, Throwable throwable) {
                    if (throwable != null) {
                        logger.debug("An error occurred when updating a trip: {}", throwable);
                    } else {
                        logger.debug("Documents modified: " + updateResult.getModifiedCount());
                    }
                }
            });
        }
    }


}
