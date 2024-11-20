package top.mcso.sms.service;

import top.mcso.sms.entity.Course;

import java.util.List;

public interface CourseService {
    boolean insertCourse(Course course);

    boolean deleteCourseByCourseNumber(String courseNumber);

    boolean updateCourse(Course course);

    Course getCourseByCourseNumber(String courseNumber);

    List<Course> getAllCourses();

    List<Course> getCoursesByPriorityCourse(String priorityCourse);

}
