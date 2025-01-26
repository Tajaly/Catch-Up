create table circle_member
(
    person_username varchar(70) references person (username),
    circle_id integer references circle (id),
    primary key (person_username, circle_id)
);