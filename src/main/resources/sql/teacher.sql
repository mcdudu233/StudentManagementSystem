create table teacher
(
    job_number  varchar(20)            not null,
    teacherName varchar(50)            not null,
    age         int                    not null,
    gender      enum ('male','female') not null,
    duty        varchar(50)            not null,
    address     varchar(50)            null,
    telephone   varchar(20)            null,
    primary key (job_number),
    foreign key (job_number) references user (user_number)
)