create table hangout
(
    id serial primary key,
    name varchar(50),
    description varchar(300),
    organizer varchar(70) references person (username),
    circle  integer references circle (id),
    start_time TIMESTAMP WITHOUT TIME ZONE,
    end_time TIMESTAMP WITHOUT TIME ZONE
);
