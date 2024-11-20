package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Classes;
import top.mcso.sms.mapper.ClassesMapper;
import top.mcso.sms.service.ClassesService;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Resource
    private ClassesMapper classesMapper;

    @Override
    public boolean insertClass(Classes classes) {
        try {
            return classesMapper.insertClass(classes);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting class", e);
        }
    }

    @Override
    public Classes getClassByNumber(int number) {
        try {
            return classesMapper.getClassByNumber(number);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting class by number: " + number, e);
        }
    }

    @Override
    public List<Classes> getAllClasses() {
        try {
            return classesMapper.getAllClasses();
        } catch (Exception e) {
            throw new RuntimeException("Error selecting all classes", e);
        }
    }

    @Override
    public boolean updateClass(Classes classes) {
        try {
            return classesMapper.updateClass(classes);
        } catch (Exception e) {
            throw new RuntimeException("Error updating class", e);
        }
    }

    @Override
    public boolean deleteClassByNumber(int number) {
        try {
            return classesMapper.deleteClassByNumber(number);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting class by number: " + number, e);
        }
    }
}
