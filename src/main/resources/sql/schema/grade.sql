create table if not exists grade
(
    course_number  varchar(20) not null,
    student_number varchar(20) not null,
    grade          float       not null,
    primary key (student_number, course_number)
);