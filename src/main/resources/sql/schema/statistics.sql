create table if not exists statistics
(
    student_number varchar(20),
    student_name   varchar(20),
    min_grade      float null,
    max_grade      float null,
    sum_grade      float null,
    avg_grade      float null,
    primary key (student_number)
);