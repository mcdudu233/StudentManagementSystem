create table teacher(
    id int not null auto_increment,
    jobNumber varchar(20) not null,
    teacherName varchar(20) not null,
    age int not null,
    gender enum('male','female') not null,
    duty varchar(50) not null,
    address varchar(50) null,
    telephone varchar(20) null,
    primary key(jobNumber),
    foreign key (jobNumber) references user(userNumber)
)