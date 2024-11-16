package top.mcso.sms.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class Student {
    private String studentNumber;
    private String name;
    private String gender;
    private int age;

    public Student(String studentNumber, String name, String gender, int age) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "学生 [学号=" + studentNumber + ", 姓名=" + name + ", 性别=" + gender + ", 年龄=" + age + "]";
    }
}