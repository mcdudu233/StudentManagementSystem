package top.mcso.sms.service;

import top.mcso.sms.entity.Course;

import java.util.List;

public interface CourseService {
    public int insertCourse(Course course);

    public int deleteCourseByCourseNumber(String courseNumber);

    public int updateCourse(Course course);

    public Course selectCourseByCourseNumber(String courseNumber);

    public List<Course> selectAllCourses();

    public List<Course> selectCoursesByPriorityCourse(String priorityCourse);

}
