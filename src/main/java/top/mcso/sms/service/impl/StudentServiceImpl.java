package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Student;
import top.mcso.sms.mapper.StudentMapper;
import top.mcso.sms.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;


    @Override
    public boolean deleteByNumber(String studentNumber) {
        try {
            return studentMapper.deleteByNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting student by number", e);
        }
    }


    @Override
    public boolean insertStudent(Student student) {
        try {
            return studentMapper.insertStudent(student);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting student", e);
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            return studentMapper.updateStudent(student);
        } catch (Exception e) {
            throw new RuntimeException("Error updating student", e);
        }
    }


    @Override
    public List<Student> getAll() {
        try {
            return studentMapper.getAll();
        } catch (Exception e) {
            throw new RuntimeException("Error listing students", e);
        }
    }


    @Override
    public Student getStudentByNumber(String studentNumber) {
        try {
            return studentMapper.getStudentByNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error getting student by name", e);
        }
    }

    @Override
    public List<Grade> getStudentScoresByNumber(String studentNumber) {
        try {
            return studentMapper.getStudentScoresByNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error getting student scores by name", e);
        }
    }
}
