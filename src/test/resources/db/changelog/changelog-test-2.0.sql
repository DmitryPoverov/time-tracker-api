--liquibase formatted sql

--changeset poverovDmitry:1
CREATE TABLE projects
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

--changeset poverovDmitry:2
INSERT INTO projects (name)
VALUES ('project1'),
       ('project2');