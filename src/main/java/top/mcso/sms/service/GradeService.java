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

    List<Grade> getAllGrades();

    List<Grade> getGradesByCourseNumber(String courseNumber);

    Float getAverageGradeByCourseNumber(String courseNumber);

    Float getMaxGradeByCourseNumber(String courseNumber);

    List<Grade> getStudentScoresByNumber(String studentNumber);

    List<Statistics> getAllStudentStatistics();

    Statistics getStatisticsByStudentNumber(String studentNumber);

    Grade getGradeByStudentNumberAndCourseNumber(String studentNumber, String courseNumber);

    List<Grade> getGradeByStudentNumber(String studentNumber);
}
