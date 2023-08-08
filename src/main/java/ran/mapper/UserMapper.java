package ran.mapper;

import de.tel.ran.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

  public User mapFromDB(ResultSet resultSet) throws SQLException {
    return new User(
        resultSet.getString("telegram_id"),
        resultSet.getString("name"),
        resultSet.getString("phone_number"),
        resultSet.getTimestamp("last_smoke").toLocalDateTime(),
        resultSet.getInt("minutes_between_smoking"),
        resultSet.getInt("cigarettes_count")
    );
  }
}
