package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Course;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    // 插入课程信息
    @Insert("insert into course (course_number, course_name, priority_course) " +
            "values (#{courseNumber}, #{courseName}, #{priorityCourse})")
    int insertCourse(Course course);

    // 根据课程编号删除课程
    @Delete("delete from course where course_number = #{courseNumber}")
    int deleteCourseByCourseNumber(@Param("courseNumber") String courseNumber);

    // 更新课程信息
    @Update("update course set course_name = #{courseName}, priority_course = #{priorityCourse} " +
            "where course_number = #{courseNumber}")
    int updateCourse(Course course);

    // 根据课程编号查询课程
    @Select("select * from course where course_number = #{courseNumber}")
    Course selectCourseByCourseNumber(@Param("courseNumber") String courseNumber);

    // 查询所有课程
    @Select("select * from course")
    List<Course> selectAllCourses();

    // 根据优先级课程查询课程列表
    @Select("select * from course where priority_course = #{priorityCourse}")
    List<Course> selectCoursesByPriorityCourse(@Param(" priorityCourse") String priorityCourse);

}
