package no.ntnu.appdev2024.jolsen.courses.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;



public class DatabaseInitializer {

    static Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    public static void main(String[] args) {

        JdbcConnection jdbcConnection = JdbcConnection.getInstance();
        try {
            jdbcConnection.connect("admin", "admin");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            Resource path = new ClassPathResource("lcon_schema.sql");

            if (jdbcConnection.isConnected()) {
                ScriptUtils.executeSqlScript(jdbcConnection.getConnection(), path);
            }

        } catch (Exception e) {
            logger.error(e.getMessage());

        }
    }

}
