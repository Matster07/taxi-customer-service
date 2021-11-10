create table if not exists drivers
(
    id     serial,
    firstname     varchar(255),
    secondname    varchar(255),
    trip_count    integer,
    creation_date timestamp
);