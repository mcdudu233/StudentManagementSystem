create table course
(
    number         int         not null,
    teacher        varchar(20) null,
    teacher_number varchar(20) null,
    student        varchar(20) null,
    student_number varchar(20) null,
    primary key (number),
    foreign key (teacher_number) references teacher (job_number),
    foreign key (student_number) references student (student_number)
)