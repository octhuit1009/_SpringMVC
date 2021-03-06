CREATE DATABASE IF NOT EXISTS test;

# user
DROP TABLE IF EXISTS test.user;
CREATE TABLE test.user (
  id       INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255)
);

# book
DROP TABLE IF EXISTS test.book;
CREATE TABLE test.book (
  id    INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) COMMENT ''
) COMMENT '';

TRUNCATE TABLE test.user;

SELECT *
FROM test.user;

SELECT *
FROM test.book;