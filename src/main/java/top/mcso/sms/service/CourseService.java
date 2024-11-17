package top.mcso.sms.service;

import top.mcso.sms.entity.Course;

import java.util.List;

public interface CourseService {
    int insertCourse(Course course);

    int deleteCourseByCourseNumber(String courseNumber);

    int updateCourse(Course course);

    Course selectCourseByCourseNumber(String courseNumber);

    List<Course> selectAllCourses();

    List<Course> selectCoursesByPriorityCourse(String priorityCourse);

}
