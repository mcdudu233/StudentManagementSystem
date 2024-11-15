create table  user (
    id int not null auto_increment, //插入记录时自动增加
    userName varchar(20) not null,
    password varcahr(20) not null,
    priority varchar(20) not null,
    userNumber varchar(20) not null,
    primary key (userNumber)
);