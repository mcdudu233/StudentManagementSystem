package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Student;

import java.util.List;

public interface StudentService {
    boolean deleteByNumber(String studentNumber);

    boolean insertStudent(Student student);

    boolean updateStudent(Student student);

    List<Student> getAll();

    Student getStudentByNumber(String studentNumber);

    List<Grade> getStudentScoresByNumber(String studentNumber);
}