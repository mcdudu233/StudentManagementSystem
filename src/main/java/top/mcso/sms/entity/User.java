package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String userNumber;
    private String password;
    private String priority;


    @Override
    public String toString() {
        return "用户 [用户名=" + userNumber + "密码" + password + "权限=" + priority + "]";
    }
}
