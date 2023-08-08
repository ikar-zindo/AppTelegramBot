package ran.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

  String telegramId;
  String name;
  String phoneNumber;
  LocalDateTime lastSmoke;
  Integer minutesBetweenSmoking;
  Integer cigarettesCount;
}
