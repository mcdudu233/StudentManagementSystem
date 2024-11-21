package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Statistics;

import java.util.List;

@Mapper
public interface GradeMapper extends BaseMapper<Grade> {
    //插入成绩
    @Insert("insert into grade(course_number, student_number, grade) " +
            "values (#{courseNumber},#{studentNumber},#{grade})")
    boolean insertGrade(Grade grade);

    //更新成绩
    @Update("update grade set course_number = #{courseNumber},student_number = #{studentNumber},grade = #{grade} " +
            "where student_number = #{studentNumber} and student_number = #{studentNumber}")
    boolean updateGrade(Grade grade);

    // 查询所有成绩
    @Select("select * from grade")
    List<Grade> getAllGrades();

    // 查询每门科目的成绩
    @Select("select * from grade where course_number = #{courseNumber}")
    List<Grade> getGradesByCourseNumber(@Param("courseNumber") String courseNumber);

    // 查询每门科目的平均分
    @Select("select avg(grade) as average from grade where course_number = #{courseNumber}")
    Float getAverageGradeByCourseNumber(@Param("courseNumber") String courseNumber);

    // 查询每门科目的最高分
    @Select("select max(grade) as maxgrade from grade where course_numbe" +
            "r = #{courseNumber}")
    Float getMaxGradeByCourseNumber(@Param("courseNumber") String courseNumber);

    //删除某个学生的某门成绩
    @Delete("delete from grade where student_number = #{studentNumber} and course_number = #{courseNumber}")
    boolean deleteGradeByStudentNumber(@Param("studentNumber") String studentNumber, @Param("courseNumber") String courseNumber);

    //删除某个学生的所有成绩
    @Delete("delete from grade where student_number = #{studentNumber}")
    boolean deleteAllGradesByStudentNumber(@Param("studentNumber") String studentNumber);

    //删除所有成绩
    @Delete("delete from grade")
    boolean deleteAllGrades();

    //删除某门课的所有成绩
    @Delete("delete from grade where course_number = #{courseNumber}")
    boolean deleteGradeByCourseNumber(@Param("courseNumber") String courseNumber);

    //查询某个学生某门课的成绩
    @Select("select * from grade where student_number = #{studentNumber} and course_number = #{courseNumber}")
    Grade getGradeByStudentNumberAndCourseNumber(@Param("studentNumber") String studentNumber, @Param("courseNumber") String courseNumber);

    //查询某个学生的所有成绩
    @Select("select * from grade where student_number = #{studentNumber}")
    List<Grade> getGradeByStudentNumber(@Param("studentNumber") String studentNumber);

    //查询学生成绩
    @Select("select s.* from grade s inner join student st on s.student_number = st.student_number where st.student_number = #{studentNumber}")
    List<Grade> getStudentScoresByNumber(@Param("studentNumber") String studentNumber);

    // 查询每一位同学的成绩、最高分、最低分、平均分和总分
    @Select({
            "select student_number, " +
                    "avg(grade) as avg_grade, " +
                    "max(grade) as max_grade, " +
                    "min(grade) as min_grade, " +
                    "sum(grade) as sum_grade " +
                    "from grade " +
                    "group by student_number"
    })
    @Results(value = {
            @Result(property = "studentNumber", column = "student_number", jdbcType = JdbcType.VARCHAR),
            @Result(property = "avgGrade", column = "avg_grade", jdbcType = JdbcType.FLOAT),
            @Result(property = "maxGrade", column = "max_grade", jdbcType = JdbcType.FLOAT),
            @Result(property = "minGrade", column = "min_grade", jdbcType = JdbcType.FLOAT),
            @Result(property = "sumGrade", column = "sum_grade", jdbcType = JdbcType.FLOAT)
    })
    List<Statistics> getAllStudentStatistics();

    // 查询特定学生的成绩、最高分、最低分、平均分和总分
    @Select({
            "select avg(grade) as avg_grade, max(grade) as max_grade, min(grade) as min_grade, sum(grade) as sum_grade " +
                    "from grade where student_number = #{studentNumber}"
    })
    @Results(value = {
            @Result(property = "avgGrade", column = "avg_grade", jdbcType = JdbcType.FLOAT),
            @Result(property = "maxGrade", column = "max_grade", jdbcType = JdbcType.FLOAT),
            @Result(property = "minGrade", column = "min_grade", jdbcType = JdbcType.FLOAT),
            @Result(property = "sumGrade", column = "sum_grade", jdbcType = JdbcType.FLOAT)
    })
    Statistics getStudentStatisticsByNumber(@Param("studentNumber") String studentNumber);

}
