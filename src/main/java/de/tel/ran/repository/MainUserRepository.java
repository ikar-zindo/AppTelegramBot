package de.tel.ran.repository;

import de.tel.ran.db.ConnectionManager;
import de.tel.ran.domian.User;
import de.tel.ran.mapper.UserMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;

public class MainUserRepository implements UserRepository {

   private PreparedStatement deleteByStatement;
   private PreparedStatement insertStatement;
   private PreparedStatement findByIdStatement;
   private UserMapper mapper;

   public MainUserRepository() {
      init();
   }

   @Override
   public User create(User user) {
      try {
         insertStatement.setString(1, user.getTelegramId());
         insertStatement.setString(2, user.getName());
         insertStatement.setString(3, user.getPhoneNumber());
         insertStatement.setTimestamp(4,
                 new Timestamp(user.getLastSmoke().toInstant(ZoneOffset.UTC).getEpochSecond()));
         insertStatement.setInt(5, user.getMinutesBetweenSmoking());
         insertStatement.setInt(6, 0);
         insertStatement.executeUpdate();
         return findByTelegramId(user.getTelegramId());
      } catch (SQLException e) {
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }

   @Override
   public void deleteByTelegramId(String telegramId) {
      try {
         System.out.printf("Deleting user with telegram id %s%n", telegramId);
         deleteByStatement.setString(1, telegramId);
         deleteByStatement.execute();
      } catch (SQLException e) {
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }

   @Override
   public User update(User user) {
      return null;
   }

   @Override
   public Integer incrementCount(String telegramId) {
      return null;
   }

   @Override
   public LocalDateTime getLastSmokeTime(String telegramId) {
      return null;
   }

   @Override
   public User getNearestUserForNotification() {
      return null;
   }

   @Override
   public Set<User> getUsersByNotificationPeriod(LocalDateTime from, LocalDateTime to) {
      return null;
   }

   @Override
   public User findByTelegramId(String telegramId) {
      ResultSet resultSet = null;
      try {
         findByIdStatement.setString(1, telegramId);
         return mapper.mapFromDB(resultSet);
      } catch (SQLException e) {
         e.printStackTrace();
         throw new RuntimeException();
      } finally {
         if (resultSet != null) {
            try {
               resultSet.close();
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      }
   }

   private void init() {
      try {
         var connection = ConnectionManager.getConnection();
         connection.createStatement().execute(UserQueries.CREATE_TABLE);
         deleteByStatement = connection.prepareStatement(UserQueries.DELETE_BY_TELEGRAM_ID);
         insertStatement = connection.prepareStatement(UserQueries.INSERT_USER);
         findByIdStatement = connection.prepareStatement(UserQueries.FIND_BY_TELEGRAM_ID);
         mapper = new UserMapper();
      } catch (SQLException e) {
         // todo make proper logging
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }
}
