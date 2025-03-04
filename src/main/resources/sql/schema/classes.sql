create table if not exists classes
(
    number         int         not null,
    teacher_number varchar(20) null,
    slogan         text        null,
    primary key (number)
);