package top.mcso.sms.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Grade {
    private String courseNumber ;
    private String studentNumber;
    private float grade;
}