package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Statistics;
import top.mcso.sms.mapper.GradeMapper;
import top.mcso.sms.service.GradeService;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    private GradeMapper gradeMapper;

    @Override
    public boolean insertGrade(Grade grade) {
        try {
            return gradeMapper.insertGrade(grade);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while inserting all grades");
        }
    }

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
    public Float findAverageGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.findaveragegradebycoursenumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while calculating the average grade for course number: " + courseNumber, e);
        }
    }

    @Override
    public Float findMaxGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.findmaxgradebycoursenumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the max grade for course number: " + courseNumber, e);
        }
    }


    @Override
    public List<Statistics> getAllStudentsGrades() {
        try {
            return gradeMapper.getAllStudentsGrades();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching all students' grades", e);
        }
    }

    @Override
    public Statistics getStudentGradesByNumber(String studentNumber) {
        try {
            Statistics statistics = gradeMapper.getStudentGradesByNumber(studentNumber);
            if (statistics == null) {
                throw new RuntimeException("No grades found for student number: " + studentNumber);
            }
            return statistics;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching grades for student number: " + studentNumber, e);
        }
    }

}
