package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Schedule;
import top.mcso.sms.mapper.ScheduleMapper;
import top.mcso.sms.service.ScheduleService;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public int insertSchedule(Schedule schedule) {
        try {
            return scheduleMapper.insertSchedule(schedule);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting schedule", e);
        }
    }

    @Override
    public int deleteScheduleByStudentNumber(String studentNumber) {
        try {
            return scheduleMapper.deleteScheduleByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting schedule by student number", e);
        }
    }

    @Override
    public int updateSchedule(Schedule schedule) {
        try {
            return scheduleMapper.updateSchedule(schedule);
        } catch (Exception e) {
            throw new RuntimeException("Error updating schedule", e);
        }
    }

    @Override
    public Schedule selectScheduleByStudentNumber(String studentNumber) {
        try {
            return scheduleMapper.selectScheduleByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting schedule by student number", e);
        }
    }

    @Override
    public List<Schedule> selectSchedulesByCourseNumber(String courseNumber) {
        try {
            return scheduleMapper.selectSchedulesByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting schedules by course number", e);
        }
    }

    @Override
    public List<Schedule> selectAllSchedules() {
        try {
            return scheduleMapper.selectAllSchedules();
        } catch (Exception e) {
            throw new RuntimeException("Error selecting all schedules", e);
        }
    }
}
