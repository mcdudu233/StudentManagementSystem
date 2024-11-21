package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Teacher;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    // 插入教师记录
    @Insert("insert into teacher (job_number, teacher_name, age, gender, duty, address, telephone) " +
            "values (#{jobNumber}, #{teacherName}, #{age}, #{gender}, #{duty}, #{address}, #{telephone})")
    boolean insertTeacher(Teacher teacher);

    // 根据工号和姓名删除教师
    @Delete("delete from teacher where job_number = #{jobNumber} and teacher_name = #{teacherName}")
    boolean deleteByJobNumberAndName(@Param("jobNumber") String jobNumber, @Param("teacherName") String teacherName);

    // 更新教师记录
    @Update("update teacher set teacher_name = #{teacherName}, age = #{age}, gender = #{gender}, " +
            "duty = #{duty}, address = #{address}, telephone = #{telephone} " +
            "where job_number = #{jobNumber}")
    boolean updateTeacher(Teacher teacher);

    // 查询所有教师
    @Select("select * from teacher")
    List<Teacher> getAll();

    // 根据工号查询教师
    @Select("select * from teacher where job_number = #{jobNumber}")
    Teacher getByJobNumber(@Param("jobNumber") String jobNumber);

    // 根据姓名查询教师
    @Select("select * from teacher where teacher_name = #{teacherName}")
    List<Teacher> getByName(@Param("teacherName") String teacherName);

}
