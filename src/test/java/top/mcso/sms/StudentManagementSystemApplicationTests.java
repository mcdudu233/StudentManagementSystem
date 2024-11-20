package top.mcso.sms;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.mcso.sms.entity.*;
import top.mcso.sms.service.*;

import java.util.Date;
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
    @Resource
    private CourseService courseService;
    @Resource
    private GradeService gradeService;
    @Resource
    private ScheduleService scheduleService;
    @Resource
    private ClassesService classesService;

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
        Long telephone = rand.nextLong();

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
        Date birthdate = new Date();


        Student student = new Student(studentNumber, studentName, gender, classes, age, address, telephone, birthdate);
        assertTrue(studentService.insertStudent(student));
        student.setAddress(UUID.randomUUID().toString().substring(0, 16));
        assertTrue(studentService.updateStudent(student));
        assertNotNull(studentService.getStudentByName(student.getStudentName()));
        assertNotNull(studentService.findAll());
        assertNotNull(studentService.getStudentScoresByName(student.getStudentName()));
        assertTrue(studentService.deleteByNumber(student.getStudentNumber()));

        //测试课程表服务
        String courseNumber = UUID.randomUUID().toString().substring(0, 8);
        String courseName = UUID.randomUUID().toString().substring(0, 8);
        String priorityCourse = UUID.randomUUID().toString().substring(0, 8);
        Course course = new Course(courseNumber, courseName, priorityCourse);
        assertTrue(courseService.insertCourse(course));
        assertNotNull(courseService.getAllCourses());
        assertNotNull(courseService.getCourseByCourseNumber(course.getCourseNumber()));
        course.setCourseName(UUID.randomUUID().toString().substring(0, 8));
        assertTrue(courseService.updateCourse(course));
        assertNotNull(courseService.getCoursesByPriorityCourse(course.getPriorityCourse()));
        assertTrue(courseService.deleteCourseByCourseNumber(course.getCourseNumber()));

        //测试成绩服务
        float grade = rand.nextFloat();
        Grade gradeTest = new Grade(courseNumber, studentNumber, grade);
        assertTrue(gradeService.insertGrade(gradeTest));
        gradeTest.setCourseNumber(UUID.randomUUID().toString().substring(0, 8));
        assertTrue(gradeService.updateGrade(gradeTest));
        assertNotNull(gradeService.getStatisticsByStudentNumber(gradeTest.getStudentNumber()));
        assertNotNull(gradeService.findAllGrades());
        assertNotNull(gradeService.getAllStudentStatistics());
        assertNotNull(gradeService.findAverageGradeByCourseNumber(gradeTest.getCourseNumber()));
        assertNotNull(gradeService.findMaxGradeByCourseNumber(gradeTest.getCourseNumber()));
        assertTrue(gradeService.deleteAllGrades());

        gradeTest.setStudentNumber(UUID.randomUUID().toString().substring(0, 8));
        assertTrue(gradeService.insertGrade(gradeTest));
        assertTrue(gradeService.deleteGradeByStudentNumber(gradeTest.getStudentNumber(), gradeTest.getCourseNumber()));

        gradeTest.setStudentNumber(UUID.randomUUID().toString().substring(0, 8));
        assertTrue(gradeService.insertGrade(gradeTest));
        assertTrue(gradeService.deleteAllGradesByStudentNumber(gradeTest.getStudentNumber()));

        //测试选课表服务
        Schedule schedule = new Schedule(studentNumber, studentName, courseName, courseNumber);
        assertTrue(scheduleService.insertSchedule(schedule));
        schedule.setStudentName(UUID.randomUUID().toString().substring(0, 8));
        assertTrue(scheduleService.updateSchedule(schedule));
        assertNotNull(scheduleService.getAllSchedules());
        assertNotNull(scheduleService.getScheduleByStudentNumber(studentNumber));
        assertNotNull(scheduleService.getSchedulesByCourseNumber(courseNumber));
        assertTrue(scheduleService.deleteScheduleByStudentNumber(studentNumber));

        //测试班级类
        int number = rand.nextInt();
        Classes classTest = new Classes(number, jobNumber, teacherName, studentNumber, studentName);
        assertTrue(classesService.insertClass(classTest));
        classTest.setStudentName(UUID.randomUUID().toString().substring(0, 8));
        assertTrue(classesService.updateClass(classTest));
        assertNotNull(classesService.getClassByNumber(number));
        assertNotNull(classesService.getAllClasses());
        assertTrue(classesService.deleteClassByNumber(number));


    }

    @Test
    void contextLoads() {
    }
}
