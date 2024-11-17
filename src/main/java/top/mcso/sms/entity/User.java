package top.mcso.sms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String username;
    private String password;
    private String priority;
    private String userNumber;


    @Override
    public String toString() {
        return "用户 [用户名=" + username + ", 用户号=" + userNumber + ", 权限=" + priority + "]";
    }
}
