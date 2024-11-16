
create table student(
    studentNumber  varchar(20) not null,
    name varchar(20) not null,
    gender enum('male','female') not null,
    age int  not null,
    class varchar(50) not null,
    primary key (studentNumber),
    foreign key (studentNumber) references user(userNumber)
)