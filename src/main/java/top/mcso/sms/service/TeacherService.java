package top.mcso.sms.service;

import top.mcso.sms.entity.Teacher;

import java.util.List;

public interface TeacherService {

    boolean insertTeacher(Teacher teacher);

    boolean deleteByJobNumberAndName(String jobNumber, String teacherName);

    boolean updateTeacher(Teacher teacher);

    List<Teacher> getAll();

    Teacher getByJobNumber(String jobNumber);

    List<Teacher> getByName(String teacherName);
}
