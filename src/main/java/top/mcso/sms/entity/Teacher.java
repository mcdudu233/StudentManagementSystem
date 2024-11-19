package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Teacher {
    private String jobNumber;
    private String teacherName;
    private String gender;
    private int age;
    private String duty;
    private String address;
    private String telephone;

}
