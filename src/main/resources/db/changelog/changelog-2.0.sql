--liquibase formatted sql

--changeset poverovDmitry:1
CREATE TABLE projects
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);