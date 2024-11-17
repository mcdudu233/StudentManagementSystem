package top.mcso.sms.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Course;
import top.mcso.sms.mapper.CourseMapper;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public int insertCourse(Course course) {
        try {
            return courseMapper.insertCourse(course);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting course", e);
        }
    }

    @Override
    public int deleteCourseByCourseNumber(String courseNumber) {
        try {
            return courseMapper.deleteCourseByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting course by course number: " + courseNumber, e);
        }
    }

    @Override
    public int updateCourse(Course course) {
        try {
            return courseMapper.updateCourse(course);
        } catch (Exception e) {
            throw new RuntimeException("Error updating course", e);
        }
    }

    @Override
    public Course selectCourseByCourseNumber(String courseNumber) {
        try {
            return courseMapper.selectCourseByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting course by course number: " + courseNumber, e);
        }
    }

    @Override
    public List<Course> selectAllCourses() {
        try {
            return courseMapper.selectAllCourses();
        } catch (Exception e) {
            throw new RuntimeException("Error selecting all courses", e);
        }
    }

    @Override
    public List<Course> selectCoursesByPriorityCourse(String priorityCourse) {
        try {
            return courseMapper.selectCoursesByPriorityCourse(priorityCourse);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting courses by priority course: " + priorityCourse, e);
        }
    }
}
