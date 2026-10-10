CREATE TABLE users (
    username VARCHAR(50) NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users
        FOREIGN KEY (username)
        REFERENCES users(username)
);

CREATE UNIQUE index ix_auth_username on authorities(username, authority);



CREATE TABLE customer(
id int NOT NULL AUTO_INCREMENT,
email varchar(55) NOT NULL,
pwd varchar(200) NOT NULL,
role varchar(45) NOT NULL,
PRIMARY KEY (id)
);
INSERT INTO customer VALUES ('happy@example.com', '{noop}EazyBytes@12345', '1');
INSERT INTO customer VALUES ('admin@example.com', '{noop}EazyBytes@12345', '1');




