create table schedule
(
    student_number varchar(20) not null,
    student_name   varchar(20) not null,
    course_name    varchar(20) not null,
    course_number  varchar(20) not null,
    primary key (student_number),
    foreign key (student_number) references student (student_number),
    foreign key (course_number) references course (course_number)
)