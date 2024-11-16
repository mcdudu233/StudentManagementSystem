package top.mcso.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Student;
import top.mcso.sms.mapper.StudentMapper;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public boolean deleteByNumber(String studentNumber) throws Exception {
        try {
            int result = studentMapper.deleteByNumber(studentNumber);
            return result > 0;
        } catch (Exception e) {
            throw new Exception("Error deleting student by number", e);
        }
    }


    @Override
    public boolean insertStudent(Student student) throws Exception {
        try {
            int result = studentMapper.insertStudent(student);
            return result > 0;
        } catch (Exception e) {
            throw new Exception("Error inserting student", e);
        }
    }

    @Override
    public boolean updateStudent(String address, String telephone, String studentNumber) throws Exception {
        try {
            int result = studentMapper.updateStudent(address, telephone, studentNumber);
            return result > 0;
        } catch (Exception e) {
            throw new Exception("Error updating student", e);
        }
    }

    @Override
    public List<Student> listStudents() throws Exception {
        try {
            return studentMapper.listStudent(null);
        } catch (Exception e) {
            throw new Exception("Error listing students", e);
        }
    }

    @Override
    public Student getStudentByName(String name) throws Exception {
        try {
            return studentMapper.getStudent(name);
        } catch (Exception e) {
            throw new Exception("Error getting student by name", e);
        }
    }

    @Override
    public List<Grade> getStudentScoresByName(String studentName) throws Exception {
        try {
            return studentMapper.getStudentScoresByName(studentName);
        } catch (Exception e) {
            throw new Exception("Error getting student scores by name", e);
        }
    }
}
