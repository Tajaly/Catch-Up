create table person
(
    username varchar(70) primary key,
    name varchar(50),
    bio varchar(300)
);

create table circle
(
    circle_id serial primary key,
    name varchar(50),
    organizer varchar(70),

    FOREIGN KEY (organizer)
    REFERENCES person(username)
    ON DELETE CASCADE
);

create table circle_member
(
    person varchar(70) references person(username),
    circle integer references  circle(circle_id)
);

create table hangout
(
    hangout_id integer unique,
    name varchar(50),
    description varchar(300),
    organizer varchar(70) references person (username),
    start_time TIMESTAMP WITHOUT TIME ZONE,
    end_time TIMESTAMP WITHOUT TIME ZONE,
    circle integer,
    circle_key integer,

    CONSTRAINT hangout_id
        PRIMARY KEY (circle, circle_key),

    FOREIGN KEY (circle)
        REFERENCES circle(circle_id)
        ON DELETE CASCADE
);
