package de.tel.ran.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

   public static final String DEFAULT_URL = "jdbc:mysql://localhost:3306/bot_db";
   public static final String DEFAULT_LOGIN = "root";
   public static final String DEFAULT_PASSWORD = "root";
   private static ConnectionManager instance;
   private Connection connection;

   private ConnectionManager() {
   }

   public static Connection getConnection() {
      if (instance != null && instance.connection != null) {
         return instance.connection;
      } else {
         throw new IllegalStateException("No credentials");
      }
   }

   public static Connection getConnection(String connectionString, String login, String password)
         throws SQLException {
      if (instance != null && instance.connection == null) {
         instance.connect(connectionString, login, password);
      } else if (instance == null){
         instance = new ConnectionManager();
         instance.connect(connectionString, login, password);
      }
      return instance.connection;
   }
   private void connect(String connectionString, String login, String password) throws SQLException {
      connection = DriverManager.getConnection(connectionString);
   }

   public void close() throws SQLException {
      if (connection != null) {
         connection.close();
      }
   }
}
