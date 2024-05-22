package no.ntnu.appdev2024.jolsen.courses.tools;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;

/**
 * A class for handling communication with a MySQL database.
 */
public class JdbcConnection {

    /**
     * Reference to the established connection.
     */
    private Connection connection;

    //@Value("${spring.datasource.url}")
    private String dbURL = "jdbc:mysql://localhost:3306/lcon";


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
     * @param user SQL user
     * @param password SQL user password
     * @throws Exception Throws exception when connection not successful.
     */
    public void connect(String user, String password)
            throws Exception {
        connection = DriverManager.getConnection(dbURL + "?user=" + user + "&password=" + password);
    }

    /**
     * Check if connection to the database is established.
     *
     * @return True when the connection is established, false otherwise.
     */
    public boolean isConnected() {
        return connection != null;
    }

    /**
     * Use to get the connection to the
     *
     * @return Connection to the database
     */
    public Connection getConnection() {
        return this.connection;
    }



}
