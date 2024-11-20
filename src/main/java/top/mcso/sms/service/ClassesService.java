package top.mcso.sms.service;

import top.mcso.sms.entity.Classes;

import java.util.List;

public interface ClassesService {
    boolean insertClass(Classes classes);

    Classes getClassByNumber(int number);

    List<Classes> getAllClasses();

    boolean updateClass(Classes classes);

    boolean deleteClassByNumber(int number);
}
