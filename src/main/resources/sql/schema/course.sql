create table if not exists course
(
    course_number   varchar(20) not null,
    course_name     varchar(50) not null,
    priority_course varchar(40) not null,
    teacher_number  varchar(20) not null,
    week            int         null,
    day             int         null,
    credit          float       null,
    spot            varchar(50) null,
    primary key (course_number)
);