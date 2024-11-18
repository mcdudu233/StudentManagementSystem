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
            int result = studentMapper.deleteByNumber(studentNumber);
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting student by number", e);
        }
    }


    @Override
    public boolean insertStudent(Student student) {
        try {
            int result = studentMapper.insertStudent(student);
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error inserting student", e);
        }
    }

    @Override
    public boolean updateStudent(String address, String telephone, String studentNumber) {
        try {
            int result = studentMapper.updateStudent(address, telephone, studentNumber);
            return result > 0;
        } catch (Exception e) {
            throw new RuntimeException("Error updating student", e);
        }
    }


    @Override
    public List<Student> findAll() {
        try {
            return studentMapper.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error listing students", e);
        }
    }


    @Override
    public Student getStudentByName(String name) {
        try {
            return studentMapper.getStudent(name);
        } catch (Exception e) {
            throw new RuntimeException("Error getting student by name", e);
        }
    }

    @Override
    public List<Grade> getStudentScoresByName(String studentName) {
        try {
            return studentMapper.getStudentScoresByName(studentName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting student scores by name", e);
        }
    }
}
