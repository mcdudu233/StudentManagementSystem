package top.mcso.sms.entity;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private String studentNumber ;
    private String name;
    private String gender;
    private String Class;
    private int age;


    @Override
    public String toString() {
        return "学生 [学号=" + studentNumber + ", 姓名=" + name + ", 性别=" + gender + ", 年龄=" + age + ", 班级= " + Class + "]";
    }
}