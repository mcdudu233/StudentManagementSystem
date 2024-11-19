package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private String studentNumber;
    private String studentName;
    private String gender;
    private String classes;
    private int age;
    private String address;
    private String telephone;
    private String birthdate;
}