package top.mcso.sms.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    private String courseNumber;
    private String courseName;
    private String priorityCourse;
}