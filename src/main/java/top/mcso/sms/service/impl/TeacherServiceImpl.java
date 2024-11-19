package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Teacher;
import top.mcso.sms.mapper.TeacherMapper;
import top.mcso.sms.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public boolean insertTeacher(Teacher teacher) {
        try {
            return teacherMapper.insertTeacher(teacher);
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert teacher", e);
        }
    }


    @Override
    public boolean deleteByJobNumberAndName(String jobNumber, String teacherName) {
        try {
            boolean result = teacherMapper.deleteByJobNumberAndName(jobNumber, teacherName);
            if (!result) {
                throw new RuntimeException("Teacher with job number " + jobNumber + " and name " + teacherName + " not found");
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete teacher by job number and name", e);
        }
    }

    @Override
    public boolean updateTeacher(Teacher teacher) {
        try {
            return teacherMapper.updateTeacher(teacher);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update teacher", e);
        }
    }

    @Override
    public List<Teacher> findAll() {
        try {
            return teacherMapper.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to find all teachers", e);
        }
    }

    @Override
    public Teacher findByJobNumber(String jobNumber) {
        try {
            return teacherMapper.findByJobNumber(jobNumber);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find teacher by job number", e);
        }
    }

    @Override
    public List<Teacher> findByName(String teacherName) {
        try {
            return teacherMapper.findByName(teacherName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to find teachers by name", e);
        }
    }
}
