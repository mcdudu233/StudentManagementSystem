package top.mcso.sms.entity;

public class User {
    private String username;
    private String password;
    private String priority;

    public User(String username, String password, String priority) {
        this.username = username;
        this.password = password;
        this.priority = priority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getpriority() {
        return priority;
    }

    public void setpriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "用户 [用户名=" + username + ", 权限=" + priority + "]";
    }
}
