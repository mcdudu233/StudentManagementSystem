create table course
(
    course_number   varchar(20) not null,
    course_name     varchar(50) not null,
    priority_course varchar(40) not null,
    week            int         null,
    day             int         null,
    credit          int         null,
    plot            int         null,
    primary key (course_number)
)