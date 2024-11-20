package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    private int number;
    private String teacherNumber;
    private String teacherName;
    private String studentNumber;
    private String studentName;
}
