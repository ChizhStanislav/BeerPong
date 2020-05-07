CREATE TABLE team
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(255)                   NOT NULL UNIQUE,
    owner_id          BIGINT references player (id)  NOT NULL,
    country_id        BIGINT references country (id) NOT NULL,
    region_id         BIGINT references region (id)  NOT NULL,
    city_id           BIGINT references city (id)    NOT NULL,
    registration_date DATE                           NOT NULL
);

CREATE TABLE game
(
    id               BIGSERIAL PRIMARY KEY,
    type             VARCHAR(15) NOT NULL,
    first_team_id    BIGINT references team (id),
    second_team_id   BIGINT references team (id),
    first_player_id  BIGINT references player (id),
    second_player_id BIGINT references player (id),
    start_date       TIMESTAMP   NOT NULL,
    finish_date      TIMESTAMP   NOT NULL

);

CREATE TABLE type_tournament
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    type_game VARCHAR(50)  NOT NULL,
    owner_id  BIGINT references player (id),
    UNIQUE (name, owner_id)
);

CREATE TABLE point
(
    id                 BIGSERIAL PRIMARY KEY,
    type               VARCHAR(50) NOT NULL,
    quantity_point     SMALLINT    NOT NULL,
    add_date           TIMESTAMP   NOT NULL,
    type_tournament_id BIGINT references type_tournament (id),
    team_id            BIGINT references team (id),
    player_id          BIGINT references player (id),
    game_id            BIGINT references game (id)
);

CREATE TABLE glass
(
    id                 BIGSERIAL PRIMARY KEY,
    type               VARCHAR(50) NOT NULL,
    quantity_glass     SMALLINT  NOT NULL,
    add_date           TIMESTAMP NOT NULL,
    type_tournament_id BIGINT references type_tournament (id),
    team_id            BIGINT references team (id),
    player_id          BIGINT references player (id),
    game_id            BIGINT references game (id)
);



CREATE TABLE tournament
(
    id                  BIGSERIAL PRIMARY KEY,
    name                VARCHAR(255)                           NOT NULL,
    owner_tournament_id BIGINT references player (id)          NOT NULL,
    type_tournament_id  BIGINT references type_tournament (id) NOT NULL,
    speciesTournament   VARCHAR(255)                           NOT NULL,
    registration_date   TIMESTAMP                              NOT NULL,
    start_date          TIMESTAMP                              NOT NULL,
    finish_date         TIMESTAMP                              NOT NULL
);

CREATE TABLE tournament_team
(
    tournament_id     BIGINT,
    team_id           BIGINT,
    first_player_id   BIGINT references player (id) NOT NULL,
    second_player_id  BIGINT references player (id) NOT NULL,
    registration_date TIMESTAMP                     NOT NULL,
    PRIMARY KEY (tournament_id, team_id)
);

