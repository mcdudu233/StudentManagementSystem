package top.mcso.sms.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    private String studentNumber ;
    private String name;
    private String gender;
    private String Class;
    private int age;
    private String address;
    private String telephone;
}