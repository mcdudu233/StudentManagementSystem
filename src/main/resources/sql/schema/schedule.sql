create table if not exists schedule
(
    student_number varchar(20) not null,
    course_number  varchar(20) not null,
    primary key (student_number, course_number)
);