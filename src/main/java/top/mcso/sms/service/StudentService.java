package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Student;

import java.util.List;

public interface StudentService {
    boolean deleteStudentByNumber(String studentNumber) throws Exception;

    boolean insertStudent(Student student) throws Exception;

    boolean updateStudent(String address, String telephone, String studentNumber) throws Exception;

    List<Student> listStudents() throws Exception;

    Student getStudentByName(String name) throws Exception;

    List<Grade> getStudentScoresByName(String studentName) throws Exception;
}