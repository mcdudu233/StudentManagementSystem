package top.mcso.sms.mapper;

import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Classes;

import java.util.List;

@Mapper
public interface ClassesMapper {
    // 插入班级信息
    @Insert("insert into classes (number,  teacher_number, slogan) " +
            "values (#{number}, #{teacherNumber},#{slogan})")
    boolean insertClass(Classes classes);

    // 根据班级编号查询班级信息
    @Select("select * from classes where number = #{number}")
    Classes getClassByNumber(@Param("number") int number);

    // 查询所有班级信息
    @Select("select * from classes")
    List<Classes> getAllClasses();

    // 更新班级信息
    @Update("update classes set  teacher_number = #{teacherNumber},slogan = #{slogan} " +
            "where number = #{number}")
    boolean updateClass(Classes classes);

    // 根据班级编号删除班级信息
    @Delete("delete from classes where number = #{number}")
    boolean deleteClassByNumber(@Param("number") int number);

}
