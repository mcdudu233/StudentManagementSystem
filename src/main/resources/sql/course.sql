create table course(
    courseNumber varvhar(20) not null,
    courseName varchar(50) not null,
    priorityCourse course not null,
    primary key (courseNumber),
)