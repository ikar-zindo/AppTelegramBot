package ran;

import de.tel.ran.db.ConnectionManager;

import java.sql.SQLException;

public class App {

  private static final String CONNECTION_ARG = "DB_CONNECTION=";
  private static final String LOGIN_ARG = "DB_LOGIN=";
  private static final String DB_PASSWORD_ARG = "DB_PASSWORD=";

  public static void main(String... args) {
    initConnection(args);
  }

  //java -jar bot-app.jar DB_CONNECTION=jdbc:mysql://localhost:3306/bot_db DB_LOGIN=VASYA DB_PASSWORD=HFHFHFHJF
  private static void initConnection(String[] args) {
    String url = ConnectionManager.DEFAULT_URL;
    String login = ConnectionManager.DEFAULT_LOGIN;
    String password = ConnectionManager.DEFAULT_PASSWORD;
    for (String arg : args) { //DB_CONNECTION=jdbc:mysql://localhost:3306/bot_db
      if (arg.startsWith(CONNECTION_ARG)) {
        url = arg.replace(CONNECTION_ARG, "");
      } else if (arg.startsWith(LOGIN_ARG)) {
        login = arg.replace(LOGIN_ARG, "");
      } else if (arg.startsWith(DB_PASSWORD_ARG)) {
        password = arg.replace(DB_PASSWORD_ARG, "");
      }
    }

    try {
       ConnectionManager.getConnection(url, login, password);
     } catch (SQLException e ) {
      e.printStackTrace();
      System.exit(-1);
    }
  }
}
