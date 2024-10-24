--liquibase formatted sql

--changeset poverovDmitry:1
CREATE TABLE records
(
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT REFERENCES users (id)    NOT NULL,
    project_id BIGINT REFERENCES projects (id) NOT NULL,
    start_time TIMESTAMP                       NOT NULL,
    end_time   TIMESTAMP
);