create table person
(
    email varchar(70) primary key,
    name varchar(50),
    bio varchar(300)
);

create table circle
(
    id serial primary key,
    name varchar(50),
    organizer varchar(70) references person (email)
);
