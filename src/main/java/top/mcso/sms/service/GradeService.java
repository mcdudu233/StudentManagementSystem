package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Statistics;

import java.util.List;

public interface GradeService {
    boolean insertGrade(Grade grade);

    List<Grade> findAllGrades();

    List<Grade> findGradesByCourseNumber(String courseNumber);

    Float findAverageGradeByCourseNumber(String courseNumber);

    Float findMaxGradeByCourseNumber(String courseNumber);

    List<Statistics> getAllStudentsGrades();

    Statistics getStudentGradesByNumber(String studentNumber);

}
