create table if not exists customers
(
    id    serial,
    creation_date timestamp,
    firstname     varchar(255),
    secondname    varchar(255),
    trip_count    integer
);