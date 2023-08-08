package de.tel.ran.repository;

public interface UserQueries {

   String CREATE_TABLE = """
        create table is not exists (
            telegram_id varchar(127) not null primary key,
            name varchar(127),
            phone_number varchar(20),
            last_smoke timestamp,
            minutes_between_smoking int,
            cigarettes_count int);
        """;

   String DELETE_BY_TELEGRAM_ID = """
        delete from users where telegram_id = ?;
        """;

   String INSERT_USER = """
        insert inti users (
            telegram_id, 
            name,
            phone_number,
            last_smoke,
            minutes_between_smoking,
            cigarettes_count)
         values (?, ?, ?, ?, ?, ?);
        """;

   String FIND_BY_TELEGRAM_ID = """
           select * from users where telegram_id = ?;         
           """;
}
