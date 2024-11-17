package top.mcso.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.mapper.GradeMapper;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> findAllGrades() {
        try {
            return gradeMapper.findallgrades();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching all grades", e);
        }
    }

    @Override
    public List<Grade> findGradesByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.findgradesbycoursenumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching grades for course number: " + courseNumber, e);
        }
    }

    @Override
    public Double findAverageGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.findaveragegradebycoursenumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while calculating the average grade for course number: " + courseNumber, e);
        }
    }

    @Override
    public Double findMaxGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.findmaxgradebycoursenumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the max grade for course number: " + courseNumber, e);
        }
    }

    @Override
    public List<Map<String, Object>> selectStudentGradesSummary() {
        try {
            return gradeMapper.selectStudentGradesSummary();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the student grades summary", e);
        }
    }

    @Override
    public Map<String, Object> selectStudentGradesSummaryByStudentNumber(String studentNumber) {
        try {
            return gradeMapper.selectStudentGradesSummaryByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the grades summary for student number: " + studentNumber, e);
        }
    }


}
