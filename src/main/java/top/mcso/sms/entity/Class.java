package top.mcso.sms.entity;

import lombok.Data;

@Data
public class Class {
    private int number;
    private String teacherNumber;
    private String teacher;
    private String studentNumber;
    private String student;

    @Override
    public String toString() {
        return "Class [number=" + number + ", teacherNumber=" + teacherNumber + ", teacher=" + teacher + ", studentNumber=" + studentNumber + ", student=" + student + "]";
    }
}
