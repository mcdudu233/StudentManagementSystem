package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Schedule;

import java.util.List;

@Mapper
public interface ScheduleMapper extends BaseMapper<Schedule> {
    // 插入学生课程表信息
    @Insert("insert into schedule (student_number, student_name, course_name, course_number) " +
            "values (#{studentNumber}, #{studentName}, #{courseName}, #{courseNumber})")
    boolean insertSchedule(Schedule schedule);

    // 根据学生编号删除课程表信息
    @Delete("delete from schedule where student_number = #{studentNumber}")
    boolean deleteScheduleByStudentNumber(@Param("studentNumber") String studentNumber);

    // 更新学生课程表信息
    @Update("update schedule set student_name = #{studentName}, course_name = #{courseName}, " +
            "course_number = #{courseNumber} where student_number = #{studentNumber}")
    boolean updateSchedule(Schedule schedule);

    // 根据学生编号查询课程表信息
    @Select("select * from schedule where student_number = #{studentNumber}")
    Schedule selectScheduleByStudentNumber(@Param("studentNumber") String studentNumber);

    // 根据课程编号查询课程表信息
    @Select("select * from schedule where course_number = #{courseNumber}")
    List<Schedule> selectSchedulesByCourseNumber(@Param("courseNumber") String courseNumber);

    // 查询所有学生课程表信息
    @Select("select * from schedule")
    List<Schedule> selectAllSchedules();
}
