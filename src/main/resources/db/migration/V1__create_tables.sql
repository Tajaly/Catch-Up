/* create table circle
(
    id serial primary key
);

 */

create table person
(
    id serial primary key,
    name varchar(50)
    /*
    circle int,
    circle_key int,
    constraint fk_circle
        foreign key (circle) references circle (id)

     */
);