CREATE DATABASE beer_pong;

CREATE TABLE player
(
    id         BIGSERIAL PRIMARY KEY,
    nick_name  VARCHAR(256)                      NOT NULL UNIQUE,
    password   VARCHAR(256)                      NOT NULL,
    email      VARCHAR(256)                      NOT NULL UNIQUE,
    country_id BIGSERIAL references country (id) NOT NULL,
    city_id    BIGSERIAL references city (id)    NOT NULL,
    role VARCHAR(256) NOT NULL
);

CREATE TABLE country
(
    id   BIGSERIAL PRIMARY KEY,
    name_english VARCHAR(256) NOT NULL UNIQUE,
    name_russian VARCHAR(256) NOT NULL UNIQUE
);

CREATE TABLE city
(
    id   BIGSERIAL PRIMARY KEY,
    name_english VARCHAR(256) NOT NULL,
    name_russian VARCHAR(256) NOT NULL,
    country_id BIGSERIAL references country(id) NOT NULL
);
