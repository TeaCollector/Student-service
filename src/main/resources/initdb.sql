CREATE TABLE IF NOT EXISTS lesson
(
    lesson_id   SERIAL PRIMARY KEY,
    lesson_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS person_progress
(
    pp_id SERIAL PRIMARY KEY,
    score INT[]
);

CREATE TABLE IF NOT EXISTS class
(
    class_id     SERIAL PRIMARY KEY,
    class_number INT
);

CREATE TABLE IF NOT EXISTS person
(
    person_id SERIAL PRIMARY KEY,
    name      VARCHAR(20) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    age       INT         NOT NULL,
    class_id  INT,
    pp_id     SERIAL,
    FOREIGN KEY (class_id) REFERENCES class (class_id),
    FOREIGN KEY (pp_id) REFERENCES person_progress (pp_id)
);

INSERT INTO lesson(lesson_name)
VALUES ('physic'),
       ('mathematics'),
       ('rus'),
       ('literature'),
       ('geometry'),
       ('informatics');

INSERT INTO class (class_number)
VALUES (1), (2), (3), (4), (5), (6), (7), (8), (9), (10), (11), (12);

