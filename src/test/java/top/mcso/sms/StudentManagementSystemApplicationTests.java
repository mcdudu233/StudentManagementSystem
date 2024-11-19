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
        String userNumber = "Y02214077";
        String password = "114514";
        // 测试用户服务
        User user = new User(userNumber, password, "admin");
        assertTrue(userService.insertUser(user));

        user.setPassword(UUID.randomUUID().toString().substring(0, 16));
        assertTrue(userService.updateUser(user));

        assertNotNull(userService.findUserByUserNumber(userNumber));
        assertFalse(userService.findAllUsers().isEmpty());

        assertTrue(userService.deleteUserByUserNumber(userNumber));
        //测试老师服务
        Teacher teacher = new Teacher("124", "余国豪", "男", 21, "讲师", "安庆", "114514");
        assertTrue(teacherService.insertTeacher(teacher));
        Teacher newTeacher = new Teacher("124", "余国豪", "女", 21, "讲师", "安庆", "114514");
        assertTrue(teacherService.updateTeacher(newTeacher));
        Teacher foundTeacher = teacherService.findByJobNumber(teacher.getJobNumber());
        assertNotNull(foundTeacher);
        assertEquals(teacher.getJobNumber(), foundTeacher.getJobNumber());
        List<Teacher> teachersByName = teacherService.findByName(teacher.getTeacherName());
        assertFalse(teachersByName.isEmpty());
        assertTrue(teachersByName.stream().anyMatch(t -> t.getTeacherName().equals(teacher.getTeacherName())));
        List<Teacher> allTeachers = teacherService.findAll();
        assertFalse(allTeachers.isEmpty());
        assertTrue(teacherService.deleteByJobNumberAndName(teacher.getJobNumber(), teacher.getTeacherName()));


        //测试学生服务
        Student student = new Student("124", "黄文豪", "女", "小班", 12, "韶关", "114514", "2002-1-1");
        assertTrue(studentService.insertStudent(student));
        Student newStudent = new Student("124", "黄文豪", "男", "小班", 12, "韶关", "114514", "2002-1-1");
        assertTrue(studentService.updateStudent(newStudent));
        assertNotNull(studentService.getStudentByName(student.getStudentName()));
        assertNotNull(studentService.findAll());
        assertNotNull(studentService.getStudentScoresByName(student.getStudentName()));
        assertTrue(studentService.deleteByNumber(student.getStudentNumber()));

    }


    @Test
    void contextLoads() {
    }
}
