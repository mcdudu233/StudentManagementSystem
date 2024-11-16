package top.mcso.sms.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@Entity
@Data

public class Teacher {
    private String jobNumber;
    private String teacherName;
    private String gender;
    private int age;
    private String duty;

    public Teacher(String jobNumber, String teacherName, String gender, int age, String duty) {
        this.jobNumber = jobNumber;
        this.teacherName = teacherName;
        this.gender = gender;
        this.age = age;
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "教师 [工号=" + jobNumber + ", 姓名=" + teacherName + ", 性别=" + gender + ", 年龄=" + age + ", 职务=" + duty + "]";
    }
}
