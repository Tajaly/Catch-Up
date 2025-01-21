create table circle_member
(
    person_email varchar(70) references person (email),
    circle_id integer references circle (id),
    primary key (person_email, circle_id)
);