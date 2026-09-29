CREATE TABLE users
(
id int PRIMARY key AUTO_INCREMENT,
username VARCHAR(50),
password VARCHAR(50)
);
INSERT into users VALUES(1,'admin','123');
SELECT * from users;
