create table if not exists student
(
    student_number varchar(20) not null,
    student_name   varchar(20) not null,
    gender         varchar(20) not null,
    age            int         not null,
    classes        int         not null,
    birthdate      date        null,
    address        varchar(50) null,
    telephone      long        null,
    primary key (student_number)
);