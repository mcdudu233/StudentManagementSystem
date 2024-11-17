package top.mcso.sms.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private String courseNumber ;
    private String studentNumber;
    private float grade;

    @Override
    public String toString() {
        return "成绩 [课程号=" + courseNumber + ", 学号=" + studentNumber + ", 成绩=" + grade + "]";
    }
}