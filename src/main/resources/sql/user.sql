create table user
(
    user_number varchar(20) not null,
    password    varchar(20) not null,
    priority    varchar(20) not null,
    primary key (user_number),
    foreign key (user_number) references student (student_number),
    foreign key (user_number) references teacher (job_number)
)