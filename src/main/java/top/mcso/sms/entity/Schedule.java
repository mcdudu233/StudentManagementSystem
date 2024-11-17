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

    @Override
    public String toString() {
        return "Schedule [studentNumber=" + studentNumber + ", studentName=" + studentName + ", courseName=" + courseName + ", teacherName=" + teacherName + "]";
    }
}
