package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;

import java.util.List;
import java.util.Map;

public interface GradeService {
    List<Grade> findAllGrades();

    List<Grade> findGradesByCourseNumber(String courseNumber);

    Double findAverageGradeByCourseNumber(String courseNumber);

    Double findMaxGradeByCourseNumber(String courseNumber);

    List<Map<String, Object>> selectStudentGradesSummary();

    Map<String, Object> selectStudentGradesSummaryByStudentNumber(String studentNumber);
}
