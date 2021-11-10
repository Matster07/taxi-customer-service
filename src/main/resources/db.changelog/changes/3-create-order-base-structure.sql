create table if not exists orders
(
    id    serial,
    destination varchar(255),
    status      varchar(255),
    start       varchar(255),
    customer_id integer,
    driver_id   integer
);