CREATE TABLE team
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(255)                   NOT NULL UNIQUE,
    owner_id          BIGINT references player (id)  NOT NULL,
    country_id        BIGINT references country (id) NOT NULL,
    region_id         BIGINT references region (id)  NOT NULL,
    city_id           BIGINT references city (id)    NOT NULL,
    registration_date TIMESTAMP                           NOT NULL
);

CREATE TABLE type_tournament
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    type_game VARCHAR(50)  NOT NULL,
    owner_id  BIGINT references player (id),
    UNIQUE (name, owner_id)
);

CREATE TABLE tournament
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(255)                           NOT NULL,
    owner_tournament_id BIGINT references player (id)          NOT NULL,
    type_tournament_id  BIGINT references type_tournament (id) NOT NULL,
    qualifier_game      SMALLINT                               NOT NULL,
    registration_date   TIMESTAMP                              NOT NULL,
    start_date          TIMESTAMP,
    finish_date         TIMESTAMP
);

CREATE TABLE tournament_team_player
(
    id                BIGSERIAL PRIMARY KEY,
    type          VARCHAR(10)                       NOT NULL,
    tournament_id     BIGINT references tournament (id) NOT NULL,
    team_id           BIGINT references team (id),
    player_id         BIGINT references player (id)     NOT NULL,
    second_player_id  BIGINT references player (id),
    point_tournament  SMALLINT,
    registration_date TIMESTAMP                         NOT NULL
);

CREATE TABLE game
(
    id            BIGSERIAL PRIMARY KEY,
    type_game     VARCHAR(20)                       NOT NULL,
    type          VARCHAR(10)                       NOT NULL,
    stage         SMALLINT                          NOT NULL,
    tournament_id BIGINT references tournament (id) NOT NULL,
    team_id       BIGINT references team (id),
    player_id     BIGINT references player (id),
    point         SMALLINT,
    glass         SMALLINT,
    start_date    TIMESTAMP                         NOT NULL,
    finish_date   TIMESTAMP
);





