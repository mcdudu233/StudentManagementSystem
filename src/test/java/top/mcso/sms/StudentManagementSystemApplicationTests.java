package top.mcso.sms;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import top.mcso.sms.entity.User;
import top.mcso.sms.service.TeacherService;
import top.mcso.sms.service.UserService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // Use transactional tests to roll back changes after each test
class StudentManagementSystemApplicationTests {

    @Resource
    private UserService userService;
    //Test for Teacher
    @Resource
    private TeacherService teacherService;

    // Test for UserService
    @Test
    void testInsertUser() {
        User user = new User("1", "2", "3");
        assertTrue(userService.insertUser(user) > 0);
    }

    @Test
    void testDeleteUserByUserNumber() {
        String userNumber = "dudu233";
        assertTrue(userService.deleteUserByUserNumber(userNumber) > 0);
    }

    @Test
    void testUpdateUser() {
        User user = new User("dudu233", "1", "2");
        assertTrue(userService.updateUser(user) > 0);
    }

    @Test
    void testFindUserByUserNumber() {
        String userNumber = "qzn";
        assertNotNull(userService.findUserByUserNumber(userNumber));
    }

    @Test
    void testFindAllUsers() {
        assertFalse(userService.findAllUsers().isEmpty());
    }


    @Test
    void contextLoads() {
    }
}
