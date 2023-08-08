package ran.repository;

public interface UserQueries {


  String CREATE_TABLE = """
      create table if not exists users (
      telegram_id varchar(127) not null primary key,
      name varchar(127),
      phone_number varchar(20),
      last_smoke timestamp,
      minutes_between_smoking integer,
      cigarettes_count integer);
      """;

  String DELETE_BY_TELEGRAM_ID = """
      delete from users where telegram_id = ?;
      """;

  String INSERT_USER = """
      insert into users (
      telegram_id,
      name,
      phone_number,
      last_smoke,
      minutes_between_smoking,
      cigarettes_count)
      values (?,?,?,?,?,?);
      """;

  String FIND_BY_TELEGRAM_ID = """
      select * from users where telegram_id = ?;
      """;
}
