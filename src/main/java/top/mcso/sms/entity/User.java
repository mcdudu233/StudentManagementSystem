package top.mcso.sms.entity;

import jakarta.persistence.Entity;
import lombok.*;

@Setter
@Getter
@Entity
@Data

public class User {
    private String username;
    private String password;
    private String priority;

    public User(String username, String password, String priority) {
        this.username = username;
        this.password = password;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "用户 [用户名=" + username + ", 权限=" + priority + "]";
    }
}
