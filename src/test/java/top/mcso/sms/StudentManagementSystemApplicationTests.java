package top.mcso.sms;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.mcso.sms.entity.User;
import top.mcso.sms.service.UserService;

@SpringBootTest
class StudentManagementSystemApplicationTests {
    @Resource
    private UserService userService;

    @Test
    void databaseTest() {
        userService.insertUser(new User());
    }

    @Test
    void contextLoads() {
    }

}
