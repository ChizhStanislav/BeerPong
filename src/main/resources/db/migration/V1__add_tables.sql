CREATE TABLE country
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE region
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) DEFAULT NULL,
    country_id BIGINT references country (id) NOT NULL
);

CREATE TABLE city
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) DEFAULT NULL,
    region_id  BIGINT references region (id)  NOT NULL,
    country_id BIGINT references country (id) NOT NULL

);

CREATE TABLE player
(
    id         BIGSERIAL PRIMARY KEY,
    nick_name  VARCHAR(256)                      NOT NULL UNIQUE,
    password   VARCHAR(256)                      NOT NULL,
    email      VARCHAR(256)                      NOT NULL UNIQUE,
    country_id BIGINT references country (id) NOT NULL,
    region_id BIGINT references region (id) NOT NULL,
    city_id    BIGINT references city (id)    NOT NULL,
    role VARCHAR(256) NOT NULL
);