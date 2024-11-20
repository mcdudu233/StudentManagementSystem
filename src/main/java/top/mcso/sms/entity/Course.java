package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Course {
    private String courseNumber;
    private String courseName;
    private String teacherNumber;
    private float credit;
    private int week;
    private int day;
    private String spot;
    private String priorityCourse;
}