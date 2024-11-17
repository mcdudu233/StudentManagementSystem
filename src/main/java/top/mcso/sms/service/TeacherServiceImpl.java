package top.mcso.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Teacher;
import top.mcso.sms.mapper.TeacherMapper;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public int insert(Teacher teacher) {
        try {
            return teacherMapper.insert(teacher);
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert teacher", e);
        }
    }

    @Override
    public int deleteByJobNumber(String jobNumber) {
        try {
            int result = teacherMapper.deleteByJobNumber(jobNumber);
            if (result == 0) {
                throw new RuntimeException("Teacher with job number " + jobNumber + " not found");
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete teacher by job number", e);
        }
    }

    @Override
    public int deleteByName(String teacherName) {
        try {
            int result = teacherMapper.deleteByName(teacherName);
            if (result == 0) {
                throw new RuntimeException("Teacher with name " + teacherName + " not found");
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete teacher by name", e);
        }
    }

    @Override
    public int deleteByJobNumberAndName(String jobNumber, String teacherName) {
        try {
            int result = teacherMapper.deleteByJobNumberAndName(jobNumber, teacherName);
            if (result == 0) {
                throw new RuntimeException("Teacher with job number " + jobNumber + " and name " + teacherName + " not found");
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete teacher by job number and name", e);
        }
    }

    @Override
    public int update(Teacher teacher) {
        try {
            return teacherMapper.update(teacher);
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
            Teacher teacher = teacherMapper.findByJobNumber(jobNumber);
            if (teacher == null) {
                throw new RuntimeException("Teacher with job number " + jobNumber + " not found");
            }
            return teacher;
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
