package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String studentNumber;
    private String name;
    private String gender;
    private String classes;
    private int age;
    private String address;
    private String telephone;


    @Override
    public String toString() {
        return "学生 [学号=" + studentNumber + ", 姓名=" + name + ", 性别=" + gender + ", 年龄=" + age + ", 班级= " + classes + ", 地址=" + address + "， 电话=" + telephone + "]";
    }
}