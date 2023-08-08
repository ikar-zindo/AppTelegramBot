package de.tel.ran.repository;

import de.tel.ran.domian.User;
import java.time.LocalDateTime;
import java.util.Set;

public interface UserRepository {
   User create(User user);
   void deleteByTelegramId(String telegramId);
   User update(User user);
   Integer incrementCount(String telegramId);
   LocalDateTime getLastSmokeTime(String telegramId);
   User getNearestUserForNotification();
   Set<User> getUsersByNotificationPeriod(LocalDateTime from, LocalDateTime to);
}
