package no.ntnu.appdev2024.jolsen.courses;

import java.sql.*;

/**
 * A class for handling communication with a MySQL database.
 */
public class JdbcConnection {

    /**
     * Reference to the established connecition.
     */
    private Connection connection;


    /**
     * Private constructor to enforce singleton pattern.
     * Use getInstance().
     */
    private JdbcConnection() {}

    /**
     * Singleton instance of the class.
     */
    private static JdbcConnection instance = new JdbcConnection();

    /**
     * Get a singleton instance of the class. Use this method everywhere where
     * you want to get access to the connection.
     *
     * @return Singleton instance
     */
    public static JdbcConnection getInstance() {
        return instance;
    }


    /**
     * Establish connection to the SQL database.
     *
     * @param host Host of the database (localhost, IP address or hostname.
     * @param port TCP port number (3306 by default)
     * @param database Database name
     * @param user SQL user
     * @param password SQL user password
     * @throws Exception Throws exception when connection not successful.
     */
    public void connect(String host, int port, String database, String user, String password)
            throws Exception {
        connection = DriverManager.getConnection("jdbc:mysql//" + host + ":" + port + "/"
                + database + "?user=" + user + "&password=" + password);
    }

    /**
     * Check if connection to the database is established.
     *
     * @return True when the ceonnection is established, false otherwise.
     */
    public boolean isConnected() {
        return connection != null;
    }



}
