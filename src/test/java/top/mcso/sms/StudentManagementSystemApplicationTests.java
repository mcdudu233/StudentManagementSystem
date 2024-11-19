package top.mcso.sms;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.mcso.sms.entity.User;
import top.mcso.sms.service.StudentService;
import top.mcso.sms.service.TeacherService;
import top.mcso.sms.service.UserService;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentManagementSystemApplicationTests {
    // 导入要测试的服务
    @Resource
    private UserService userService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;

    @Test
    void testDatabase() {

        // 随机产生用户名和密码
        String username = UUID.randomUUID().toString().substring(0, 8);
        String password = UUID.randomUUID().toString().substring(0, 16);

        // 测试用户服务
        User user = new User(username, password, "admin");
        assertTrue(userService.insertUser(user) > 0);

        user.setPassword(UUID.randomUUID().toString().substring(0, 16));
        assertTrue(userService.updateUser(user) > 0);

        assertNotNull(userService.findUserByUserNumber(username));
        assertFalse(userService.findAllUsers().isEmpty());

        assertTrue(userService.deleteUserByUserNumber(username) > 0);
    }


    @Test
    void contextLoads() {
    }
}
