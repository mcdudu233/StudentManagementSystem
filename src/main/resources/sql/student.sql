create table student
(
    student_number varchar(20)            not null,
    name           varchar(20)            not null,
    gender         enum ('male','female') not null,
    age            int                    not null,
    class          varchar(50)            not null,
    birth_date     date               null,
    address        varchar(50)            null,
    telephone      varchar(20)            null,
    primary key (student_number),
    foreign key (student_number) references user (user_number)
)