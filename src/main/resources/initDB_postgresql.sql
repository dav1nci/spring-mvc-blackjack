DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 1;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_name  VARCHAR NOT NULL,
  password   VARCHAR NOT NULL
);
CREATE UNIQUE INDEX unique_email ON USERS (user_name);