package com.riczy.carless.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import com.google.gson.Gson;
import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides access to the database client so that data inserts, updates, reads
 * and deletes may occur for this application. To gain access to the client use
 * the {#getDatabase} method.
 * </p>
 *
 * This client assumes that a properties file containing the database
 * configuration settings are established. The following properties may be
 * configured:
 *
 * <ul>
 * <li>db.host - The mongodb service host</li>
 * <li>db.port - The mongodb service port</li>
 * <li>db.name - The mongodb database name</li>
 * </ul>
 */
class DatabaseClient {

    protected final static Logger logger = LoggerFactory.getLogger(DatabaseClient.class);

    private final static DatabaseClient databaseClient;

    private MongoClient client;
    private String databaseHost;
    private String databaseName;
    private Integer databasePort;

    static {
        databaseClient = new DatabaseClient();
    }

    private DatabaseClient() {

        loadProperties();
        initializeMongoClient();
    }

    /**
     * The database client associated with this application.
     *
     * @return  The database client associated with this application.
     */
    static MongoDatabase getDatabase() {
        return databaseClient.getMongoDB();
    }

    /**
     * Converts the Document instance to an instance with type specified by the
     * entityClass parameter.
     *
     * @param   entityClass The class that the returned instance will be.
     *          Required.
     * @param   dbObject The Document instance that is to be converted into its
     *          representative entityClass type. Required.
     * @return  An instance of type T that contains the values from dbObject.
     */
    static <T> T fromDocument(final Class<T> entityClass, final Document dbObject) {

        return new Gson().fromJson(dbObject.toJson(), entityClass);
    }

    /**
     * Converts a pojo instance into a Document instance.
     *
     * @param   entity The instance to convert into a Document. Required.
     * @return  The Document representation of the domain parameter.
     */
    static Document toDocument(final Object entity) {

        return Document.parse(new Gson().toJson(entity));
    }

    /**
     * Loads the configuration properties that are needed to initialize the
     * database client.
     */
    private void loadProperties() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = getClass().getResourceAsStream("/config.properties");
            prop.load(input);

            if (logger.isDebugEnabled()) {
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteStream);
                prop.list(printStream);
                logger.debug(byteStream.toString());
            }

            databaseHost = prop.getProperty("db.host", "localhost");
            databaseName = prop.getProperty("db.name", "carless");
            databasePort = new Integer(prop.getProperty("db.port", "27017"));

        } catch (Exception e) {
            logger.error("An error occurred when accessing and reading the configuration properties.", e);
            throw new RuntimeException("An error occurred when accessing and reading the configuration properties.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error("An error occurred when closing the input stream for the configuration properties.");
                }
            }
        }
    }

    /**
     * Initializes the mongodb client. This initialization assumes that the database
     * properties are set.
     */
    private void initializeMongoClient() {

        ConnectionString connection = new ConnectionString("mongodb://" + databaseHost + ":" + databasePort + "/" + databaseName);
        client = MongoClients.create(connection);
    }

    /**
     * Returns the MongoDB client associated with the database of this
     * application.
     *
     * @return  The MongoDB client database for this application.
     */
    private MongoDatabase getMongoDB() {
        return databaseClient.client.getDatabase(databaseName);
    }
}