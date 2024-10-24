--liquibase formatted sql

--changeset poverovDmitry:1
CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role     VARCHAR(64)  NOT NULL
);

--changeset poverovDmitry:2
INSERT INTO users (username, password, role)
VALUES ('mail1@mail.by', 'noop{123}', 'ADMIN'),
       ('mail2@mail.by', 'noop{123}', 'USER'),
       ('mail3@mail.by', 'noop{123}', 'USER');