package top.mcso.sms.mapper;

import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper {
    // 插入教师记录
    @Insert("insert into teacher (job_number, teachername, age, gender, duty, address, telephone) " +
            "values (#{jobNumber}, #{teacherName}, #{age}, #{gender}, #{duty}, #{address}, #{telephone})")
    int insert(Teacher teacher);

    // 删除指定教师
    @Delete("delete from teacher where job_number = #{jobNumber}")
    int deleteByJobNumber(@Param("jobNumber") String jobNumber);

    // 根据姓名删除教师
    @Delete("delete from teacher where teachername = #{teacherName}")
    int deleteByName(@Param("teacherName") String teacherName);

    // 根据工号和姓名删除教师
    @Delete("delete from teacher where job_number = #{jobNumber} and teachername = #{teacherName}")
    int deleteByJobNumberAndName(@Param("jobNumber") String jobNumber, @Param("teacherName") String teacherName);

    // 更新教师记录
    @Update("update teacher set teachername = #{teacherName}, age = #{age}, gender = #{gender}, " +
            "duty = #{duty}, address = #{address}, telephone = #{telephone} " +
            "where job_number = #{jobNumber}")
    int update(Teacher teacher);

    // 查询所有教师
    @Select("select * from teacher")
    List<Teacher> findAll();

    // 根据工号查询教师
    @Select("select * from teacher where job_number = #{jobNumber}")
    Teacher findByJobNumber(@Param("jobNumber") String jobNumber);

    // 根据姓名查询教师
    @Select("select * from teacher where teachername = #{teacherName}")
    List<Teacher> findByName(@Param("teacherName") String teacherName);

}
