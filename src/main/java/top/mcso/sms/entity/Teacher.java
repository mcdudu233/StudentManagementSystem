package top.mcso.sms.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private String jobNumber;
    private String teacherName;
    private String gender;
    private int age;
    private String duty;
    private String address;
    private String telephone;

    @Override
    public String toString() {
        return "教师 [工号=" + jobNumber + ", 姓名=" + teacherName + ", 性别=" + gender + ", 年龄=" + age + ", 职务=" + duty + ", 地址=" + address + "， 电话=" + telephone + "]";
    }
}
