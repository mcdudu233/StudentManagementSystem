package top.mcso.sms.mapper;

import org.apache.ibatis.annotations.*;
import top.mcso.sms.entity.Grade;

import java.util.List;
import java.util.Map;

@Mapper
public interface GradeMapper {
    // 查询所有成绩
    @Select("select * from grade")
    List<Grade> findallgrades();

    // 查询每门科目的成绩
    @Select("select * from grade where course_number = #{courseNumber}")
    List<Grade> findgradesbycoursenumber(@Param("courseNumber") String courseNumber);

    // 查询每门科目的平均分
    @Select("select avg(grade) as average from grade where course_number = #{courseNumber}")
    Double findaveragegradebycoursenumber(@Param("courseNumber") String courseNumber);

    // 查询每门科目的最高分
    @Select("select max(grade) as maxgrade from grade where course_number = #{courseNumber}")
    Double findmaxgradebycoursenumber(@Param("courseNumber") String courseNumber);

    // 查询每一位同学的成绩、最高分、最低分、平均分和总分
    @Select("select " +
            "g.student_number, " +
            "sum(g.grade) as total_score, " +
            "max(g.grade) as max_score, " +
            "min(g.grade) as min_score, " +
            "avg(g.grade) as average_score " +
            "from grade g " +
            "group by g.student_number")
    @Results(value = {
            @Result(property = "student_number", column = "student_number"),
            @Result(property = "total_score", column = "total_score"),
            @Result(property = "max_score", column = "max_score"),
            @Result(property = "min_score", column = "min_score"),
            @Result(property = "average_score", column = "average_score")
    })
    List<Map<String, Object>> selectStudentGradesSummary();

    // 查询特定学生的成绩、最高分、最低分、平均分和总分
    @Select("select " +
            "student_number, " +
            "sum(grade) as total_score, " +
            "max(grade) as max_score, " +
            "min(grade) as min_score, " +
            "avg(grade) as average_score " +
            "from grade " +
            "where student_number = #{studentNumber} " +
            "group by student_number")
    @Results(value = {
            @Result(property = "studentNumber", column = "student_number"),
            @Result(property = "totalScore", column = "total_score"),
            @Result(property = "maxScore", column = "max_score"),
            @Result(property = "minScore", column = "min_score"),
            @Result(property = "averageScore", column = "average_score")
    })
    Map<String, Object> selectStudentGradesSummaryByStudentNumber(@Param("studentNumber") String studentNumber);

}
