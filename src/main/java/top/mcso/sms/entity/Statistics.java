package top.mcso.sms.entity;

import lombok.Data;

@Data
public class Statistics {
    private String studentNumber;
    private String studentName;
    private float minGrade;
    private float maxGrade;
    private float avgGrade;
    private float sumGrade;


}
