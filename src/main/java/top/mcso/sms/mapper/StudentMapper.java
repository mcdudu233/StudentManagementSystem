package top.mcso.sms.mapper;

import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    //增删方法
    //删除指定学生
    @Delete("delete from student where student_number = #{student_number}")
    int deleteByNumber(@Param("student_number") String student_number);

    //插入学生记录
    @Insert("insert into student (student_number, name, gender, age, class, birth_date) values (#{student_name},#{name},#{gender},#{age},#{class},#{birthdate})")
    int insertStudent(@Param("student") Student student);

    //更新学生
    @Update("update student set address=#{address},telephone=#{telephone} where student_number = #{student_number} ")
    int updateStudent(@Param("address") String address,
                      @Param("telephone") String telephone,
                      @Param("student_number") String student_number);

    //查询方法
    //查询所有学生
    @Select("select * from student")
    List<Student> findAll();

    //查询指定学生
    @Select("select * from student where name = #{name}")
    Student getStudent(@Param("name") String name);

    //查询学生成绩
    @Select("select s.* from grade s inner join student st on s.student_number = st.student_number where st.name = #{studentName}")
    List<Grade> getStudentScoresByName(@Param("studentName") String studentName);


}