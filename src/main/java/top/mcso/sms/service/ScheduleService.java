package top.mcso.sms.service;

import top.mcso.sms.entity.Schedule;

import java.util.List;

public interface ScheduleService {
    int insertSchedule(Schedule schedule);

    int deleteScheduleByStudentNumber(String studentNumber);

    int updateSchedule(Schedule schedule);

    Schedule selectScheduleByStudentNumber(String studentNumber);

    List<Schedule> selectSchedulesByCourseNumber(String courseNumber);

    List<Schedule> selectAllSchedules();
}
