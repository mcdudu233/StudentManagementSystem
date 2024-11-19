create table student
(
    student_number varchar(20) not null,
    student_name   varchar(20) not null,
    gender         varchar(20) not null,
    age            int         not null,
    class          varchar(50) not null,
    birthdate      date        null,
    address        varchar(50) null,
    telephone      varchar(20) null,
    primary key (student_number),
    foreign key (student_number) references user (user_number)
)