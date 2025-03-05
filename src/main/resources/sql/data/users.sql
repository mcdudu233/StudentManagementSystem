insert ignore into user
values ("admin", "admin", "admin"),
       ("Y00000001", "123456", "student"),
       ("S0001", "123456", "teacher");

insert ignore into student (`student_number`, `student_name`, `gender`, `age`, `classes`, `birthdate`, `address`,
                            `telephone`)
values ('Y00000001', '嘟嘟', '男', '20', '1', '2004-1-1', '广州', '15865652698');

insert ignore into teacher (`job_number`, `teacher_name`, `age`, `gender`, `duty`, `address`, `telephone`)
values ('S0001', '周施', '36', '男', '老师', '安徽', '15698535568');