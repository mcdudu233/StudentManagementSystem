create table teacher(
    id int not null auto_increment,
    jobNumber varchar(20) not null,
    teacherName varchar(20) not null,
    age int not null,
    gender enum('male','female') not null,
    duty varchar(50) not null,
    primary key(jobNumber),
)