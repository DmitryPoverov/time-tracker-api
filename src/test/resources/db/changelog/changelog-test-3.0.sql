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

--changeset poverovDmitry:2
INSERT INTO records (user_id, project_id, start_time)
VALUES (1, 1, '2024-10-21 14:37:11'),
       (2, 2, '2024-10-22 14:37:11');