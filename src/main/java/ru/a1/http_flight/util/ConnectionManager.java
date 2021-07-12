package ru.a1.http_flight.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    static {
        loadDriver();
    }

    private static final String URL = "db.url";
    private static final String LOGIN =  "db.login";
    private static final String  PASSWORD = "db.password";

    private ConnectionManager() {
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException(e);
        }
    }

    public static Connection open ()  {
       try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL),
                    PropertiesUtil.get(LOGIN),
                    PropertiesUtil.get(PASSWORD)
            );
       } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
