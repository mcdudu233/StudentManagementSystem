create table if not exists user
(
    user_number varchar(20) not null,
    password    varchar(20),
    priority    varchar(20) not null,
    primary key (user_number)
);