insert ignore into classes (`number`, `teacher_number`, `slogan`)
values ('202', 'S0001', 'oneclass');

insert ignore into course (`course_number`, `course_name`, `priority_course`, `teacher_number`, `week`, `day`, `credit`,
                           `spot`)
values ('G0001', '大学英语', '', 'S0001', '3', '2', '3', '教东233'),
       ('X0001', 'Java技术及应用', 'G0004', 'S0001', '5', '4', '3', '塔楼T02');

insert ignore into schedule (`student_number`, `course_number`)
values ('Y00000001', 'G0001'),
       ('Y00000001', 'X0001');

insert ignore into grade (`course_number`, `student_number`, `grade`)
values ('G0001', 'Y00000001', '75');