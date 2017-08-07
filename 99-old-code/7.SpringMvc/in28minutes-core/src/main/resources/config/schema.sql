CREATE TABLE user (
  id int IDENTITY NOT NULL PRIMARY KEY,
  name varchar(32) DEFAULT NULL,
  email varchar(32) NOT NULL,
  password varchar(32) DEFAULT NULL
);

ALTER TABLE user ADD CONSTRAINT unique_email UNIQUE (email);

CREATE TABLE todoitem (
  id int IDENTITY NOT NULL PRIMARY KEY,
  userId int NOT NULL,
  title varchar(512) DEFAULT NULL,
  done boolean DEFAULT FALSE NOT NULL,
  priority tinyint NOT NULL,
  dueDate date DEFAULT NULL
);

alter table todoitem add constraint user_fk foreign key (userId) references user(id);