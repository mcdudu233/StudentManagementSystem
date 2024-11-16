package top.mcso.sms.service;

import top.mcso.sms.entity.Teacher;

import java.util.List;

public interface TeacherService {
    int insert(Teacher teacher);

    int deleteByJobNumber(String jobNumber);

    int deleteByName(String teacherName);

    int deleteByJobNumberAndName(String jobNumber, String teacherName);

    int update(Teacher teacher);

    List<Teacher> findAll();

    Teacher findByJobNumber(String jobNumber);

    List<Teacher> findByName(String teacherName);
}
