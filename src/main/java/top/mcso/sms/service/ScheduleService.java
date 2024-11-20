package top.mcso.sms.service;

import top.mcso.sms.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    boolean insertSchedule(Schedule schedule);

    boolean deleteScheduleByStudentNumber(String studentNumber);

    boolean updateSchedule(Schedule schedule);

    List<Schedule> getScheduleByStudentNumber(String studentNumber);

    List<Schedule> getSchedulesByCourseNumber(String courseNumber);

    List<Schedule> getAllSchedules();
}
