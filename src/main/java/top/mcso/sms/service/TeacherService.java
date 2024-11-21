package top.mcso.sms.service;

import top.mcso.sms.entity.Teacher;

import java.util.List;

public interface TeacherService {

    boolean insertTeacher(Teacher teacher);

    boolean deleteByJobNumber(String jobNumber);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> getAll();

    Teacher getByJobNumber(String jobNumber);

    List<Teacher> getByName(String teacherName);
}
