package top.mcso.sms.service;

import top.mcso.sms.entity.Teacher;

import java.util.List;

public interface TeacherService {

    boolean insertTeacher(Teacher teacher);

    boolean deleteByJobNumber(String jobNumber);

    boolean deleteByName(String teacherName);

    boolean deleteByJobNumberAndName(String jobNumber, String teacherName);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> findAll();

    Teacher findByJobNumber(String jobNumber);

    List<Teacher> findByName(String teacherName);
}
