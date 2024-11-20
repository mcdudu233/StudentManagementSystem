package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Statistics;

import java.util.List;

public interface GradeService {
    boolean insertGrade(Grade grade);

    boolean updateGrade(Grade grade);

    boolean deleteAllGrades();

    boolean deleteAllGradesByStudentNumber(String studentNumber);

    boolean deleteGradeByStudentNumber(String studentNumber, String courseNumber);

    boolean deleteGradeByCourseNumber(String courseNumber);

    List<Grade> findAllGrades();

    List<Grade> findGradesByCourseNumber(String courseNumber);

    Float findAverageGradeByCourseNumber(String courseNumber);

    Float findMaxGradeByCourseNumber(String courseNumber);

    List<Statistics> getAllStudentStatistics();

    Statistics getStatisticsByStudentNumber(String studentNumber);


}
