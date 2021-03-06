package com.company.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB {
    private static PostgresDB instance;
    private Connection connection;



    private PostgresDB(){
        try {
            Class.forName("org.postgresql.Driver");
            String password = "1703";
            String username = "postgres";
            String url = "jdbc:postgresql://localhost:5432/bank";
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException var2) {
            System.out.println("Database Connection Creation Failed : " + var2.getMessage());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public Connection getConnection() {
        return this.connection;
    }

    public static PostgresDB getInstance() throws SQLException {
        if (instance == null) {
            instance = new PostgresDB();
        } else if (instance.getConnection().isClosed()) {
            instance = new PostgresDB();
        }

        return instance;
    }
}
