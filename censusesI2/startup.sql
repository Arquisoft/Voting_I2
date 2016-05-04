USE voters;

CREATE TABLE voters.user (
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  nif VARCHAR(255) NOT NULL,
  polling_station_code INT NOT NULL,
  password VARCHAR(255) NOT NULL
);