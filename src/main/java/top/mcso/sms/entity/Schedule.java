package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private String studentNumber;
    private String studentName;
    private String courseName;
    private String courseNumber;
}
