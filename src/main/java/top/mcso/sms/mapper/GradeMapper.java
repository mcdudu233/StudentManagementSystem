package top.mcso.sms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Statistics;

import java.util.List;

@Mapper
public interface GradeMapper extends BaseMapper<Grade> {
    //插入成绩
    @Insert("insert into grade(course_number, student_number, grade) " +
            "values (#{courseNumber},#{studentNUmber},#{grade})")
    boolean insertGrade(Grade grade);

    // 查询所有成绩
    @Select("select * from grade")
    List<Grade> findallgrades();

    // 查询每门科目的成绩
    @Select("select * from grade where course_number = #{courseNumber}")
    List<Grade> findgradesbycoursenumber(@Param("courseNumber") String courseNumber);

    // 查询每门科目的平均分
    @Select("select avg(grade) as average from grade where course_number = #{courseNumber}")
    Float findaveragegradebycoursenumber(@Param("courseNumber") String courseNumber);

    // 查询每门科目的最高分
    @Select("select max(grade) as maxgrade from grade where course_number = #{courseNumber}")
    Float findmaxgradebycoursenumber(@Param("courseNumber") String courseNumber);


    // 查询每一位同学的成绩、最高分、最低分、平均分和总分
    @Select("select r.student_number, r.student_name, min(g.grade) as min_grade, max(g.grade) as max_grade, sum(g.grade) as sum_grade, avg(g.grade) as avg_grade " +
            "from statistics r join grade g on r.student_number = g.student_number " +
            "group by r.student_number")
    List<Statistics> getAllStudentsGrades();

    // 查询特定学生的成绩、最高分、最低分、平均分和总分
    @Select("select r.student_number, r.student_name, min(g.grade) as min_grade, max(g.grade) as max_grade, sum(g.grade) as sum_grade, avg(g.grade) as avg_grade " +
            "from statistics r join grade g on r.student_number = g.student_number " +
            "where r.student_number = #{studentNumber} " +
            "group by r.student_number")
    Statistics getStudentGradesByNumber(String studentNumber);

}
