create table users(
                      id serial primary key,
                      name varchar(255) not null,
                      surname varchar(255) not null,
                      identity_num varchar(11) not null unique,
                      user_role varchar(16),
                      user_name varchar(255),
                      password varchar(16)




);

create table lectures(
                         id serial primary key,
                         name varchar(255) not null,
                         teacher_id integer not null,
                         CONSTRAINT fk_teacher_id
                             FOREIGN KEY (teacher_id)
                                 REFERENCES users(id)


);




create table user_lectures(
                              user_id integer not null,
                              lecture_id integer not null,
                              CONSTRAINT fk_users_id
                                  FOREIGN KEY (user_id)
                                      REFERENCES users(id),
                              CONSTRAINT fk_lecture_id
                                  FOREIGN KEY (lecture_id)
                                      REFERENCES lectures(id)

);

ALTER TABLE users
    ADD COLUMN gender varchar(6);
