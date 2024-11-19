create table teacher
(
    job_number   varchar(20) not null,
    teacher_name varchar(50) not null,
    age          int         not null,
    gender       varchar(20) not null,
    duty         varchar(50) not null,
    address      varchar(50) null,
    telephone    long        null,
    primary key (job_number)
)