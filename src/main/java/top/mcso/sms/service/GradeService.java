package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Statistics;

import java.util.List;

public interface GradeService {
    List<Grade> findAllGrades();

    List<Grade> findGradesByCourseNumber(String courseNumber);

    Double findAverageGradeByCourseNumber(String courseNumber);

    Double findMaxGradeByCourseNumber(String courseNumber);

    List<Statistics> getAllStudentsGrades();

    Statistics getStudentGradesByNumber(String studentNumber);

}
