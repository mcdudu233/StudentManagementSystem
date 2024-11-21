package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    //增删方法
    //删除指定学生
    @Delete("delete from student where student_number = #{student_number}")
    boolean deleteByNumber(@Param("student_number") String student_number);

    //插入学生记录
    @Insert("insert into student (student_number, student_name, gender, age, classes, birthdate,address,telephone) values (#{studentNumber},#{studentName},#{gender},#{age},#{classes},#{birthdate},#{address},#{telephone})")
    boolean insertStudent(Student student);

    //更新学生
    @Update("update student set student_number =#{studentNumber},student_name = #{studentName},gender = #{gender},age = #{age},classes = #{classes},address=#{address},telephone=#{telephone} where student_number = #{studentNumber} ")
    boolean updateStudent(Student student);

    //查询方法
    //查询所有学生
    @Select("select * from student")
    List<Student> getAll();

    //查询指定学生
    @Select("select * from student where student_number = #{studentNumber}")
    Student getStudentByNumber(@Param("studentNumber") String studentNumber);


}