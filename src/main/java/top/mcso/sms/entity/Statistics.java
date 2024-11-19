package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
    private String studentNumber;
    private String studentName;
    private float minGrade;
    private float maxGrade;
    private float avgGrade;
    private float sumGrade;


}
