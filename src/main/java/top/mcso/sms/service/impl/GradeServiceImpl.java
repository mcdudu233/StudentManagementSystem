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
    public boolean updateGrade(Grade grade) {
        try {
            return gradeMapper.updateGrade(grade);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating all grades");
        }
    }

    @Override
    public boolean deleteAllGrades() {
        try {
            return gradeMapper.deleteAllGrades();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting all grades");
        }
    }

    @Override
    public boolean deleteAllGradesByStudentNumber(String studentNumber) {
        try {
            return gradeMapper.deleteAllGradesByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting all grades");
        }
    }

    @Override
    public boolean deleteGradeByStudentNumber(String studentNumber, String courseNumber) {
        try {
            return gradeMapper.deleteGradeByStudentNumber(studentNumber, courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting all grades");
        }

    }

    @Override
    public boolean deleteGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.deleteGradeByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting all grades");
        }
    }

    @Override
    public List<Grade> getAllGrades() {
        try {
            return gradeMapper.getAllGrades();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching all grades", e);
        }
    }

    @Override
    public List<Grade> getGradesByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.getGradesByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching grades for course number: " + courseNumber, e);
        }
    }

    @Override
    public Float getAverageGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.getAverageGradeByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while calculating the average grade for course number: " + courseNumber, e);
        }
    }

    @Override
    public Float getMaxGradeByCourseNumber(String courseNumber) {
        try {
            return gradeMapper.getMaxGradeByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the max grade for course number: " + courseNumber, e);
        }
    }


    @Override
    public List<Statistics> getAllStudentStatistics() {
        try {
            return gradeMapper.getAllStudentStatistics();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching all students' grades", e);
        }
    }

    @Override
    public Statistics getStatisticsByStudentNumber(String studentNumber) {
        try {
            Statistics statistics = gradeMapper.getStudentStatisticsByNumber(studentNumber);
            if (statistics == null) {
                throw new RuntimeException("No grades found for student number: " + studentNumber);
            }
            return statistics;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching grades for student number: " + studentNumber, e);
        }
    }

    @Override
    public Grade getGradeByStudentNumberAndCourseNumber(String studentNumber, String courseNumber) {
        try {
            return gradeMapper.getGradeByStudentNumberAndCourseNumber(studentNumber, courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching grades for student number and course number", e);
        }
    }

    @Override
    public List<Grade> getGradeByStudentNumber(String studentNumber) {
        try {
            return gradeMapper.getGradeByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching grades for student number", e);
        }
    }

}
