package top.mcso.sms.entity;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor

public class User {
    private String username;
    private String password;
    private String priority;
    private String userNumber;

    public User(String username, String password, String priority, String userNumber) {
        this.username = username;
        this.password = password;
        this.priority = priority;
        this.userNumber = userNumber;
    }

    @Override
    public String toString() {
        return "用户 [用户名=" + username + ", 用户号=" + userNumber + ", 权限=" + priority + "]";
    }
}
