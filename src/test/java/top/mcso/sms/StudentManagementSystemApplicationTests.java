package top.mcso.sms;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.mcso.sms.entity.Student;
import top.mcso.sms.entity.Teacher;
import top.mcso.sms.entity.User;
import top.mcso.sms.service.StudentService;
import top.mcso.sms.service.TeacherService;
import top.mcso.sms.service.UserService;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentManagementSystemApplicationTests {
    private static Random rand = new Random();
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
        String userNumber = UUID.randomUUID().toString().substring(0, 8);
        String password = UUID.randomUUID().toString().substring(0, 16);
        // 测试用户服务
        User user = new User(userNumber, password, "admin");
        assertTrue(userService.insertUser(user));

        user.setPassword(UUID.randomUUID().toString().substring(0, 16));
        assertTrue(userService.updateUser(user));

        assertNotNull(userService.findUserByUserNumber(userNumber));
        assertFalse(userService.findAllUsers().isEmpty());

        assertTrue(userService.deleteUserByUserNumber(userNumber));

        // 测试老师服务
        String jobNumber = UUID.randomUUID().toString().substring(0, 8);
        String teacherName = UUID.randomUUID().toString().substring(0, 8);
        String gender = rand.nextBoolean() ? "男" : "女";
        int age = rand.nextInt();
        String duty = UUID.randomUUID().toString().substring(0, 4);
        String address = UUID.randomUUID().toString().substring(0, 8);
        String telephone = UUID.randomUUID().toString().substring(0, 11);

        Teacher teacher = new Teacher(jobNumber, teacherName, gender, age, duty, address, telephone);
        assertTrue(teacherService.insertTeacher(teacher));
        teacher.setAddress(UUID.randomUUID().toString().substring(0, 16));
        assertTrue(teacherService.updateTeacher(teacher));
        Teacher foundTeacher = teacherService.findByJobNumber(teacher.getJobNumber());
        assertNotNull(foundTeacher);
        assertEquals(teacher.getJobNumber(), foundTeacher.getJobNumber());
        List<Teacher> teachersByName = teacherService.findByName(teacher.getTeacherName());
        assertFalse(teachersByName.isEmpty());
        assertTrue(teachersByName.stream().anyMatch(t -> t.getTeacherName().equals(teacher.getTeacherName())));
        List<Teacher> allTeachers = teacherService.findAll();
        assertFalse(allTeachers.isEmpty());
        assertTrue(teacherService.deleteByJobNumberAndName(teacher.getJobNumber(), teacher.getTeacherName()));

        // 测试学生服务
        String studentNumber = UUID.randomUUID().toString().substring(0, 8);
        String classes = UUID.randomUUID().toString().substring(0, 4);
        String studentName = UUID.randomUUID().toString().substring(0, 3);

        Student student = new Student(studentNumber, studentName, gender, classes, age, address, telephone, "2002-1-1");
        assertTrue(studentService.insertStudent(student));
        student.setAddress(UUID.randomUUID().toString().substring(0, 16));
        assertTrue(studentService.updateStudent(student));
        assertNotNull(studentService.getStudentByName(student.getStudentName()));
        assertNotNull(studentService.findAll());
        assertNotNull(studentService.getStudentScoresByName(student.getStudentName()));
        assertTrue(studentService.deleteByNumber(student.getStudentNumber()));
    }


    @Test
    void contextLoads() {
    }
}
