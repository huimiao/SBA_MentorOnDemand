CREATE TABLE USERS
(
    id bigint IDENTITY(10001,1) primary key,
    user_name              VARCHAR(128) unique NOT NULL,
    password               VARCHAR(256) NOT NULL,
    first_name             VARCHAR(128) NOT NULL DEFAULT '',
    last_name              VARCHAR(128) NOT NULL DEFAULT '',
    contact_number         bigint  NOT NULL DEFAULT 0,
    reg_datetime           TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active                 BOOLEAN      NOT NULL DEFAULT true,
    confirmed_signup       BOOLEAN      NOT NULL DEFAULT false
);


CREATE TABLE roles
(
    id bigint IDENTITY(10001,1) primary key,
    role VARCHAR(256) unique NOT NULL
);


CREATE TABLE user_role
(
    id bigint IDENTITY(10001,1) primary key,
    uid BIGINT NOT NULL,
    rid BIGINT NOT NULL
);
