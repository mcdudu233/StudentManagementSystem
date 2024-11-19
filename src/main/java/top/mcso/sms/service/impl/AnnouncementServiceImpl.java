package top.mcso.sms.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.mcso.sms.entity.Announcement;
import top.mcso.sms.mapper.AnnouncementMapper;
import top.mcso.sms.service.AnnouncementService;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private AnnouncementMapper announcementMapper;

    @Override
    public boolean addAnnouncement(Announcement announcement) {
        try {
            return announcementMapper.insertAnnouncement(announcement);
        } catch (Exception e) {
            throw new RuntimeException("Error adding announcement", e);
        }
    }

    @Override
    public boolean removeAnnouncementById(String id) {
        try {
            return announcementMapper.deleteAnnouncementById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error removing announcement by id: " + id, e);
        }
    }

    @Override
    public boolean updateAnnouncement(Announcement announcement) {
        try {
            return announcementMapper.updateAnnouncement(announcement);
        } catch (Exception e) {
            throw new RuntimeException("Error updating announcement", e);
        }
    }

    @Override
    public Announcement getAnnouncementById(String id) {
        try {
            return announcementMapper.selectAnnouncementById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting announcement by id: " + id, e);
        }
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        try {
            return announcementMapper.selectAllAnnouncements();
        } catch (Exception e) {
            throw new RuntimeException("Error getting all announcements", e);
        }
    }
}
