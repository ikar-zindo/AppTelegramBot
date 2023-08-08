package de.tel.ran.repository;

import de.tel.ran.domian.User;

import java.time.LocalDateTime;
import java.util.Set;

public class MainUserRepository implements UserRepository {

   @Override
   public User create(User user) {
      return null;
   }

   @Override
   public void deleteByTelegramId(String telegramId) {

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
}
