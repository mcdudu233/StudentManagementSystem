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
    public boolean insertSchedule(Schedule schedule) {
        try {
            return scheduleMapper.insertSchedule(schedule);
        } catch (Exception e) {
            throw new RuntimeException("Error inserting schedule", e);
        }
    }

    @Override
    public boolean deleteScheduleByStudentNumber(String studentNumber) {
        try {
            return scheduleMapper.deleteScheduleByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting schedule by student number", e);
        }
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        try {
            return scheduleMapper.updateSchedule(schedule);
        } catch (Exception e) {
            throw new RuntimeException("Error updating schedule", e);
        }
    }

    @Override
    public List<Schedule> getScheduleByStudentNumber(String studentNumber) {
        try {
            return scheduleMapper.getScheduleByStudentNumber(studentNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting schedule by student number", e);
        }
    }

    @Override
    public List<Schedule> getSchedulesByCourseNumber(String courseNumber) {
        try {
            return scheduleMapper.getSchedulesByCourseNumber(courseNumber);
        } catch (Exception e) {
            throw new RuntimeException("Error selecting schedules by course number", e);
        }
    }

    @Override
    public List<Schedule> getAllSchedules() {
        try {
            return scheduleMapper.getAllSchedules();
        } catch (Exception e) {
            throw new RuntimeException("Error selecting all schedules", e);
        }
    }
}
