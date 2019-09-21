CREATE SCHEMA banana;
CREATE TABLE banana.banana_data(
    waffle int,
    tacos varchar,
    pancakes bool
);
SELECT * FROM banana_data;
CREATE TABLE banana.user(
    name varchar,
    password varchar,
    id varchar primary key,
    email varchar
);
--DROP TABLE banana.user;