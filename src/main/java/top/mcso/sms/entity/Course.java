package top.mcso.sms.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String courseNumber;
    private String courseName;
    private String priorityCourse;

    @Override
    public String toString() {
        return "课程 [课程号=" + courseNumber + ", 课程名=" + courseName + ", 先修课程=" + priorityCourse + "]";
    }
}