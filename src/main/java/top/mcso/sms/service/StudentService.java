package top.mcso.sms.service;

import top.mcso.sms.entity.Grade;
import top.mcso.sms.entity.Student;

import java.util.List;

public interface StudentService {
    boolean deleteByNumber(String studentNumber);

    boolean insertStudent(Student student);

    boolean updateStudent(String address, String telephone, String studentNumber);

    List<Student> listStudents();

    Student getStudentByName(String name);

    List<Grade> getStudentScoresByName(String studentName);
}