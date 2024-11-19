package top.mcso.sms.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private String studentNumber;
    private String studentName;
    private String courseName;
    private String teacherName;
}
