package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Course;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    // 插入课程信息
    @Insert("insert into course (course_number, course_name,teacher_number,credit,week,day, priority_course) " +
            "values (#{courseNumber}, #{courseName},#{teacherNumber},#{credit},#{week},#{day}, #{priorityCourse})")
    boolean insertCourse(Course course);

    // 根据课程编号删除课程
    @Delete("delete from course where course_number = #{courseNumber}")
    boolean deleteCourseByCourseNumber(@Param("courseNumber") String courseNumber);

    // 更新课程信息
    @Update("update course set course_name = #{courseName},teacher_number = #{teacherNumber},credit = #{credit},week = #{week},day = #{day}, priority_course = #{priorityCourse} " +
            "where course_number = #{courseNumber}")
    boolean updateCourse(Course course);

    // 根据课程编号查询课程
    @Select("select * from course where course_number = #{courseNumber}")
    Course getCourseByCourseNumber(@Param("courseNumber") String courseNumber);

    // 查询所有课程
    @Select("select * from course")
    List<Course> getAllCourses();

    // 根据优先级课程查询课程列表
    @Select("select * from course where priority_course = #{priorityCourse}")
    List<Course> getCoursesByPriorityCourse(@Param("priorityCourse") String priorityCourse);

}
